package com.shanebeestudios.mcdeob.app.listener;

import com.shanebeestudios.mcdeob.app.App;
import com.shanebeestudios.mcdeob.util.I18n;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnapshotButtonListener implements ActionListener {

    private final App app;

    public SnapshotButtonListener(App app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JToggleButton snapshotToggleButton = this.app.getSnapshotToggleButton();
        if (snapshotToggleButton.isSelected()) {
            snapshotToggleButton.setSelected(true);
            snapshotToggleButton.setText(I18n.tr("app.toggle.releases"));
            this.app.setupVersions(true);
        } else {
            snapshotToggleButton.setSelected(false);
            snapshotToggleButton.setText(I18n.tr("app.toggle.snapshots"));
            this.app.setupVersions(false);
        }
    }

}
