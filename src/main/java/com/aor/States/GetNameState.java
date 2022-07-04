package com.aor.States;

import com.aor.BomberMan;
import com.aor.InputHandler.KeyboardController;
import com.aor.LanternaGui.LanternaGUI;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class GetNameState extends GameState{
    StringBuilder stringBuilder;
    KeyboardController keyboardController = new KeyboardController();
    public GetNameState(BomberMan game) {
        super(game);
    }

    @Override
    public void start() {
        super.bomberMan.terminal.addKeyListener(keyboardController);
        stringBuilder = new StringBuilder();
    }

    @Override
    public void update(BomberMan bomberMan) throws IOException, InterruptedException {
        super.bomberMan.screen.clear();
        TextGraphics t = super.bomberMan.screen.newTextGraphics();
        t.setBackgroundColor(TextColor.Factory.fromString("#CBE1EF"));
        t.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(LanternaGUI.width, LanternaGUI.height), ' ');
        drawText(t);
        drawString(t);
        Selectable();
        super.bomberMan.screen.refresh();
    }

    private void drawString(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#880808"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(5,6 ), stringBuilder.toString());
    }

    private void drawText(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00bd03"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(5,5 ), "YOUR USERNAME : ");
    }

    private void Selectable() {
        if(keyboardController.CharUpdated){
            stringBuilder.append(keyboardController.chare);
            keyboardController.CharUpdated = false;
        }
        else if(keyboardController.delete){
            stringBuilder.setLength(Math.max(stringBuilder.length() - 1, 0));
            keyboardController.delete = false;
        }
        else if(keyboardController.end){
            super.bomberMan.terminal.removeKeyListener(keyboardController);
            super.bomberMan.user.setName(stringBuilder.toString());
            changeState(new LeaderboardState(this.bomberMan));
            return;
        }else if(keyboardController.skip){
            super.bomberMan.terminal.removeKeyListener(keyboardController);
            changeState(new LeaderboardState(this.bomberMan));
            return;
        }
    }
}
