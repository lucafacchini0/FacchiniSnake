package com.lucafacchini;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WindowManager extends JPanel implements Runnable {

    public WindowManager() {
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setBackground(Color.BLACK);

        // Window updater
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this, 0, 16, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        System.out.println("thread test");
    }
}
