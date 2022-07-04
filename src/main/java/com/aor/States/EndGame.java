package com.aor.States;

import com.aor.BomberMan;
import com.aor.InputHandler.MenuController;
import com.aor.LanternaGui.LanternaGUI;
import com.aor.Leaderboard.LeaderboardFactory;
import com.aor.Leaderboard.LeaderboardObject;
import com.aor.Models.EndGameModel.EndGameModel;
import com.aor.Models.EndGameModel.MenuEnd;
import com.aor.Models.EndGameModel.PlayAgainEnd;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;

public class EndGame extends GameState{
    EndGameModel play,menu;
    MenuController menuController = new MenuController();
    LeaderboardFactory leaderboardFactory;
    int winBool;
    long timeCurrent;
    public EndGame(BomberMan game,int win,long time1) {
        super(game);
        play = new PlayAgainEnd();
        menu = new MenuEnd();
        winBool = win;
        timeCurrent = time1;
    }

    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(menuController);
        play.setSelected();
        if(winBool == 1){
            leaderboardFactory = new LeaderboardFactory("src/main/resources/Leaderboard/leaderboard.txt");
            try {
                leaderboardFactory.updateLeaderboardFile(new LeaderboardObject(super.bomberMan.user.getName(), Math.toIntExact(super.bomberMan.user.getTime())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void update(BomberMan bomberMan) throws IOException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        play.draw(t);
        menu.draw(t);
        drawBestScoreUser(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }
    private void drawBestScoreUser(TextGraphics graphics){
        if(winBool == 0 ){
            graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
            graphics.enableModifiers(SGR.BOLD);
            String s = "YOU LOSE";
            graphics.putString(new TerminalPosition(18,2 ), s);
            return;
        }

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFEA17"));
        graphics.enableModifiers(SGR.BOLD);
        String s = "YOUR BEST TIME - " + super.bomberMan.user.getTime();
        graphics.putString(new TerminalPosition(5,2 ), s);

        graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
        graphics.enableModifiers(SGR.BOLD);
        String t = "CURRENT TIME - " + timeCurrent;
        graphics.putString(new TerminalPosition(5,4 ), t);
    }

    private void Selectable() {
        if(menuController.down){
            menuController.down = false;
            if(play.isSelected()){
                play.setUnselected();
                menu.setSelected();
            }
        }
        if(menuController.up){
            menuController.up = false;
            if(menu.isSelected()){
                menu.setUnselected();
                play.setSelected();
            }
        }
        if(menuController.Enter){
            menuController.Enter = false;
            doAction();
        }
    }

    private void doAction() {
        if(menu.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new MenuState(this.bomberMan));
            return;
        }
        if(play.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            try {
                changeState(new PlayingState(this.bomberMan));
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
