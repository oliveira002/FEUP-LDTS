package com.aor.LanternaGui;

import com.googlecode.lanterna.TerminalSize;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LanternaGUI{

    static public int width = 45;
    static public int height = 13;

    public LanternaGUI(){
    }
    static public AWTTerminalFrame AWTTerminalFrameFactory(){

        try {
            AWTTerminalFrame terminal;
            TerminalSize terminalSize = new TerminalSize(width, height);

            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).setTerminalEmulatorTitle("BOMBERMAN");
            terminalFactory.setForceAWTOverSwing(true);

            terminalFactory.setTerminalEmulatorFontConfiguration(setFont("src/main/resources/fonts/FonteFinal.ttf",80));

            Terminal terminal1 = terminalFactory.createTerminal();


            terminal =(AWTTerminalFrame)terminal1;

            terminal.exitPrivateMode();

            return terminal;

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return new AWTTerminalFrame();
    }

    protected static Font GetFont(String name,int size) throws IOException, FontFormatException {
        File fontFile = new File(name);
        Font font = Font.createFont(Font.TRUETYPE_FONT,fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loaded = font.deriveFont(Font.PLAIN,size);
        return loaded;
    }

    protected static AWTTerminalFontConfiguration setFont(String lf, int size) throws IOException, FontFormatException {
        return AWTTerminalFontConfiguration.newInstance(GetFont(lf,size));
    }

}
