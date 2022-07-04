package com.aor.States;

import com.aor.BomberMan;
import com.aor.InputHandler.MenuController;
import com.aor.LanternaGui.LanternaGUI;
import com.aor.Leaderboard.LeaderboardFactory;
import com.aor.Leaderboard.LeaderboardObject;

import com.aor.Models.LeaderBoardModel.BackMenu;
import com.aor.Models.LeaderBoardModel.ChangeUser;
import com.aor.Models.LeaderBoardModel.LeaderBoardModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.ArrayList;


public class LeaderboardState extends GameState{
    LeaderBoardModel user,menu;
    ArrayList<LeaderboardObject> leaderboardObjects;
    LeaderboardFactory leaderboardFactory;
    MenuController menuController = new MenuController();
    public LeaderboardState(BomberMan game) {
        super(game);
        leaderboardFactory = new LeaderboardFactory("src/main/resources/Leaderboard/leaderboard.txt");
        user = new ChangeUser();
        menu = new BackMenu();
    }

    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(menuController);
        leaderboardObjects = leaderboardFactory.getLeaderboardsList();
        menu.setSelected();
        user.setUnselected();
    }

    @Override
    public void update(BomberMan bomberMan) throws IOException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        drawLeaderBoard(t);
        drawBestScoreUser(t);
        drawText(t);
        menu.draw(t);
        user.draw(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }
    private void drawLeaderBoard(TextGraphics graphics){
        int place = 6;
        int couter = 0;
        for(LeaderboardObject sus : leaderboardObjects){
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFEA17"));
            graphics.enableModifiers(SGR.BOLD);
            Integer time = sus.getTime();
            String name = sus.getName();
            String s = name + " : " + time.toString() + " (SEC)";
            graphics.putString(new TerminalPosition(12,place ), s);
            place = place + 2;
            couter = couter +1;
            if(couter >= 3){
                break;
            }
        }

    }
    private void drawText(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(16,4 ), "TOP 3");
    }
    private void drawBestScoreUser(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
        graphics.enableModifiers(SGR.BOLD);
        String s = super.bomberMan.user.getName() + " : " + super.bomberMan.user.getTime();
        graphics.putString(new TerminalPosition(30,2 ), s);
    }

    private void Selectable(){
        if(menuController.down){
            menuController.down = false;
            if(menu.isSelected()){
                menu.setUnselected();
                user.setSelected();
            }
        }
        if(menuController.up){
            menuController.up = false;
            if(user.isSelected()){
                user.setUnselected();
                menu.setSelected();
            }
        }
        if(menuController.Enter){
            menuController.Enter = false;
            doAction();
        }
    }
    private void doAction(){
        if(menu.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new MenuState(this.bomberMan));
            return;
        }
        if(user.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new GetNameState(this.bomberMan));
            return;
        }
    }
}
