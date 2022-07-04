package com.aor.States;

import com.aor.BomberMan;
import com.aor.InputHandler.MenuController;
import com.aor.LanternaGui.LanternaGUI;
import com.aor.Models.PauseModels.MenuPause;
import com.aor.Models.PauseModels.PauseModel;
import com.aor.Models.PauseModels.ResumePause;
import com.aor.Models.PauseModels.ShopPause;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.io.IOException;

public class PauseState extends GameState{
    PauseModel resume,shop,menu;
    MenuController menuController = new MenuController();
    public PauseState(BomberMan game) {
        super(game);
        resume = new ResumePause();
        shop = new ShopPause();
        menu = new MenuPause();
        music.startPauseMusic();
    }

    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(menuController);
        resume.setSelected();
        shop.setUnselected();
        menu.setUnselected();
    }

    @Override
    public void update(BomberMan bomberMan) throws IOException, InterruptedException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        resume.draw(t);
        shop.draw(t);
        menu.draw(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }
    private void Selectable(){
        if(menuController.down){
            menuController.down = false;
            if(resume.isSelected()){
                resume.setUnselected();
                shop.setSelected();
            }
            else if(shop.isSelected()){
                shop.setUnselected();
                menu.setSelected();
            }
        }
        if(menuController.up){
            menuController.up = false;
            if(menu.isSelected()){
                menu.setUnselected();
                shop.setSelected();
            }
            else if(shop.isSelected()){
                shop.setUnselected();
                resume.setSelected();
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
            changeState(new MenuState(super.bomberMan));
            music.endPauseMusic();
            return;
        }
        if(resume.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            setLastGameState();
            music.endPauseMusic();
            return;
        }
        if(shop.isSelected()){
            super.bomberMan.terminal.removeKeyListener(menuController);
            super.bomberMan.setGameStateBeforeShop(super.bomberMan.getGameLastState());
            changeState(new ShopState(this.bomberMan));
            return;
        }

    }
}
