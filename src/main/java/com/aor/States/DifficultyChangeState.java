package com.aor.States;
import com.aor.BomberMan;
import com.aor.InputHandler.MenuController;
import com.aor.LanternaGui.LanternaGUI;
import com.aor.Models.RobotsSettingsModel.DifficultyModel;
import com.aor.Models.RobotsSettingsModel.EasyRobots;
import com.aor.Models.RobotsSettingsModel.HardRobots;
import com.aor.Strategy.FollowHeroMovement;
import com.aor.Strategy.RandomMovement;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class DifficultyChangeState extends GameState {
    DifficultyModel easy,hard;
    MenuController menuController = new MenuController();

    public DifficultyChangeState(BomberMan game) {
        super(game);
        easy = new EasyRobots();
        hard = new HardRobots();
    }
    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(menuController);
        easy.setSelected();
        hard.setUnselected();
    }

    @Override
    public void update(BomberMan bomberMan) throws IOException, InterruptedException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        easy.draw(t);
        hard.draw(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }

    private void Selectable() throws InterruptedException {
        if(menuController.down){
            menuController.down = false;
            if(easy.isSelected()){
                easy.setUnselected();
                hard.setSelected();
            }
        }
        if(menuController.up){
            menuController.up = false;
            if(hard.isSelected()){
                hard.setUnselected();
                easy.setSelected();
            }
        }
        if(menuController.Enter){
            menuController.Enter = false;
            music.confirmationSfx();
            Thread.sleep(500);
            doAction();
        }
    }
    private void doAction(){
        if(easy.isSelected()){
            super.bomberMan.strategy = new RandomMovement();
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new MenuState(this.bomberMan));
            return;
        }
        if(hard.isSelected()){
            super.bomberMan.strategy = new FollowHeroMovement();
            super.bomberMan.terminal.removeKeyListener(menuController);
            changeState(new MenuState(this.bomberMan));
            return;
        }
    }
}
