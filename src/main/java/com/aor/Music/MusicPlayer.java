package com.aor.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.Objects;

public class MusicPlayer {
    private final Clip backgroundMusic, bombMusic, winMusic, loseMusic, bombExplosion, footstep, scroll, pauseMusic, enter, mainMenu, error, confirmation;



    public MusicPlayer() {
        this.backgroundMusic= loadMusic();
        this.bombMusic = loadBombMusic();
        this.winMusic = loadWinMusic();
        this.bombExplosion = loadBombExplosion();
        this.loseMusic = loadLossMusic();
        this.footstep = loadFootStep();
        this.scroll = loadScroll();
        this.pauseMusic = loadPauseMusic();
        this.enter = loadEnterSfx();
        this.mainMenu = loadMainMenuMusic();
        this.error = loadErrorSfx();
        this.confirmation = loadConfirmationSfx();
    }

    private Clip loadMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/theme_song2.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadBombMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/bomb.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadWinMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/win.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadLossMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/lose.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-5.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadBombExplosion() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/soft_explosion.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clip loadFootStep() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/footsteps.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadScroll() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/scroll.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadPauseMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/pauseSong.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clip loadEnterSfx() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/enter2.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadMainMenuMusic() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/mainMenuMusic.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadConfirmationSfx() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/confirmation.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Clip loadErrorSfx() throws NullPointerException{
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/music/error.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void startBombMusic() {
        try {
            if(bombMusic.isRunning()){
                bombMusic.stop();
            }
            bombMusic.setMicrosecondPosition(0);
            bombMusic.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startGameMusic() {
        try {
            if(backgroundMusic.isRunning()){
                backgroundMusic.stop();
            }
            backgroundMusic.setMicrosecondPosition(0);
            backgroundMusic.start();
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void endGameMusic() {
        try {
            backgroundMusic.stop();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void startMenuMusic() {
        try {
            if(mainMenu.isRunning()){
                mainMenu.stop();
            }
            mainMenu.setMicrosecondPosition(0);
            mainMenu.start();
            mainMenu.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void endMainMusic() {
        try {
            mainMenu.stop();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startPauseMusic() {
        try {
            if(pauseMusic.isRunning()){
                pauseMusic.stop();
            }
            pauseMusic.setMicrosecondPosition(0);
            pauseMusic.start();
            pauseMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void endPauseMusic() {
        try {
            pauseMusic.stop();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void startWinMusic() {
        try {
            if(winMusic.isRunning()){
                winMusic.stop();
            }
            winMusic.setMicrosecondPosition(0);
            winMusic.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startLoseMusic() {
        try {
            if(loseMusic.isRunning()){
                loseMusic.stop();
            }
            loseMusic.setMicrosecondPosition(0);
            loseMusic.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startBombExplosionMusic() {
        try {
            if(bombExplosion.isRunning()){
                bombExplosion.stop();
            }
            bombExplosion.setMicrosecondPosition(0);
            bombExplosion.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startFootstep() {
        try {
            if(footstep.isRunning()){
                footstep.stop();
            }
            footstep.setMicrosecondPosition(0);
            footstep.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startScrollSound() {
        try {
            if(scroll.isRunning()){
                scroll.stop();
            }
            scroll.setMicrosecondPosition(0);
            scroll.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void enterSoundEffect() {
        try {
            if(enter.isRunning()){
                enter.stop();
            }
            enter.setMicrosecondPosition(0);
            enter.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void errorSfx() {
        try {
            if(error.isRunning()){
                error.stop();
            }
            error.setMicrosecondPosition(0);
            error.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void confirmationSfx() {
        try {
            if(confirmation.isRunning()){
                confirmation.stop();
            }
            confirmation.setMicrosecondPosition(0);
            confirmation.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}