package com.aor.States;

import com.aor.BomberMan;
import com.aor.InputHandler.MenuController;
import com.aor.LanternaGui.LanternaGUI;
import com.aor.Models.MenuModels.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.awt.*;
import java.io.IOException;

public class MenuState extends GameState{
    MenuModel play,shop,leaderboard,exit,options;
    MenuController menuController = new MenuController();

    public MenuState(BomberMan game) {
        super(game);
        play = new Play();
        shop = new ShopMenu();
        leaderboard = new LeaderBoard();
        exit = new ExitMenu();
        options = new OptionsModel();
    }

    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(menuController);
        play.setSelected();
        shop.setUnselected();
        leaderboard.setUnselected();
        exit.setUnselected();
        music.startMenuMusic();
        options.setUnselected();

    }

    @Override
    public void update(BomberMan bomberMan) throws IOException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        play.draw(t);
        shop.draw(t);
        leaderboard.draw(t);
        options.draw(t);
        exit.draw(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }
    private void Selectable(){
        if(menuController.down){
            menuController.down = false;
            if(play.isSelected()){
                play.setUnselected();
                shop.setSelected();
            }
            else if(shop.isSelected()){
                shop.setUnselected();
                leaderboard.setSelected();
            }
            else if(leaderboard.isSelected()){
                leaderboard.setUnselected();
                options.setSelected();
            }
            else if(options.isSelected()) {
                options.setUnselected();
                exit.setSelected();
            }
        }
        if(menuController.up){
            menuController.up = false;
            if(exit.isSelected()){
                exit.setUnselected();
                options.setSelected();
            }
            else if(options.isSelected()) {
                options.setUnselected();
                leaderboard.setSelected();
            }
            else if(leaderboard.isSelected()){
                leaderboard.setUnselected();
                shop.setSelected();
            }
            else if(shop.isSelected()){
                shop.setUnselected();
                play.setSelected();
            }
        }
        if(menuController.Enter){
            menuController.Enter = false;
            doAction();
        }
    }
    private void doAction(){
        if(play.isSelected()){
            try {
                music.endMainMusic();
                super.bomberMan.terminal.removeKeyListener(menuController);
                music.endMainMusic();
                changeState(new PlayingState(this.bomberMan));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (FontFormatException e) {
                e.printStackTrace();
            }
            return;
        }
        if(shop.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            super.bomberMan.setGameStateBeforeShop(super.bomberMan.getGameLastState());
            changeState(new ShopState(this.bomberMan));
            return;
        }
        if(leaderboard.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new LeaderboardState(this.bomberMan));
            music.endMainMusic();
            return;
        }
        if(exit.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            music.endMainMusic();
            changeState(null);
            return;
        }
        if(options.isSelected()) {
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new DifficultyChangeState(this.bomberMan));
            music.endMainMusic();
            return;
        }
    }
}
