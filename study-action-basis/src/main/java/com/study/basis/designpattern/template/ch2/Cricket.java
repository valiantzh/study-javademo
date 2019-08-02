package com.study.basis.designpattern.template.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Cricket extends Game{
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
