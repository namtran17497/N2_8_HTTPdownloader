package main;

import main.DownloadManager;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI extends javax.swing.JFrame implements Observer{

	private static final long serialVersionUID = 8489399426552541643L;
	
	private DownloadTableModel mTableModel;
	
	private Downloader mSelectedDownloader;
	
	private boolean mIsClearing;
        
    public GUI() {
    	mTableModel = new DownloadTableModel();
        initComponents();
        initialize();
    }
    
    private void initialize() {
        
    	jtbDownload.getSelectionModel().addListSelectionListener(new
                ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
            }
        });
        
    	jtbDownload.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	
        ProgressRenderer renderer = new ProgressRenderer(0, 100);
        renderer.setStringPainted(true); 
        jtbDownload.setDefaultRenderer(JProgressBar.class, renderer);
        jtbDownload.setRowHeight(
                (int) renderer.getPreferredSize().getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxURL = new javax.swing.JTextField();
        jbnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDownload = new javax.swing.JTable();
        jbnPause = new javax.swing.JButton();
        jbnRemove = new javax.swing.JButton();
        jbnCancel = new javax.swing.JButton();
        jbnExit = new javax.swing.JButton();
        jbnResume = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Download Manager");
        setResizable(false);

        jbnAdd.setText("Download");
        jbnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnAddActionPerformed(evt);
            }
        });

        jtbDownload.setModel(mTableModel);
        jScrollPane1.setViewportView(jtbDownload);

        jbnPause.setText("Pause");
        jbnPause.setEnabled(false);
        jbnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnPauseActionPerformed(evt);
            }
        });

        jbnRemove.setText("Remove");
        jbnRemove.setEnabled(false);
        jbnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnRemoveActionPerformed(evt);
            }
        });

        jbnCancel.setText("Cancel");
        jbnCancel.setEnabled(false);
        jbnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnCancelActionPerformed(evt);
            }
        });

        jbnExit.setText("Exit");
        jbnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnExitActionPerformed(evt);
            }
        });

        jbnResume.setText("Resume");
        jbnResume.setEnabled(false);
        jbnResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnResumeActionPerformed(evt);
            }
        });

        jLabel1.setText("URL:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxURL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnResume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbnAdd))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jbnPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbnResume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbnExit)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnPauseActionPerformed
    	mSelectedDownloader.pause();
        updateButtons();
    }//GEN-LAST:event_jbnPauseActionPerformed

    private void jbnResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnResumeActionPerformed
    	mSelectedDownloader.resume();
        updateButtons();
    }//GEN-LAST:event_jbnResumeActionPerformed

    private void jbnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnCancelActionPerformed
    	mSelectedDownloader.cancel();
        updateButtons();
    }//GEN-LAST:event_jbnCancelActionPerformed

    private void jbnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnRemoveActionPerformed
    	mIsClearing = true;
    	int index = jtbDownload.getSelectedRow();
    	DownloadManager.getInstance().removeDownload(index);
    	mTableModel.clearDownload(index);
        mIsClearing = false;
        mSelectedDownloader = null;
        updateButtons();
    }//GEN-LAST:event_jbnRemoveActionPerformed

    private void jbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbnExitActionPerformed

    private void jbnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnAddActionPerformed
    	URL verifiedUrl = DownloadManager.verifyURL(jtxURL.getText());
        if (verifiedUrl != null) {
        	Downloader download = DownloadManager.getInstance().createDownload(verifiedUrl, 
        			DownloadManager.DEFAULT_OUTPUT_FOLDER);
        	mTableModel.addNewDownload(download);
        	jtxURL.setText("");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Download URL (invalid URL format or file type). Please re-enter download URL", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbnAddActionPerformed

    private void tableSelectionChanged() {
        if (mSelectedDownloader != null)
        	mSelectedDownloader.deleteObserver(GUI.this);
        if (!mIsClearing) {
        	int index = jtbDownload.getSelectedRow();
        	if (index != -1) {
	        	mSelectedDownloader = DownloadManager.getInstance().getDownload(jtbDownload.getSelectedRow());
	        	mSelectedDownloader.addObserver(GUI.this);
        	} else
        		mSelectedDownloader = null;
            updateButtons();
        }
    }
    
    @Override
	public void update(Observable o, Object arg) {
        if (mSelectedDownloader != null && mSelectedDownloader.equals(o))
            updateButtons();
	}
    
    private void updateButtons() {
        if (mSelectedDownloader != null) {
            int state = mSelectedDownloader.getState();
            switch (state) {
                case Downloader.DOWNLOADING:
                    jbnPause.setEnabled(true);
                    jbnResume.setEnabled(false);
                    jbnCancel.setEnabled(true);
                    jbnRemove.setEnabled(false);
                    break;
                case Downloader.PAUSED:
                    jbnPause.setEnabled(false);
                    jbnResume.setEnabled(true);
                    jbnCancel.setEnabled(true);
                    jbnRemove.setEnabled(false);
                    break;
                case Downloader.ERROR:
                    jbnPause.setEnabled(false);
                    jbnResume.setEnabled(true);
                    jbnCancel.setEnabled(false);
                    jbnRemove.setEnabled(true);
                    break;
                default: 
                    jbnPause.setEnabled(false);
                    jbnResume.setEnabled(false);
                    jbnCancel.setEnabled(false);
                    jbnRemove.setEnabled(true);
            }
        } else {
            jbnPause.setEnabled(false);
            jbnResume.setEnabled(false);
            jbnCancel.setEnabled(false);
            jbnRemove.setEnabled(false);
        }
    }
    
    public static void main(String args[]) {
    	try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {
	}
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnAdd;
    private javax.swing.JButton jbnCancel;
    private javax.swing.JButton jbnExit;
    private javax.swing.JButton jbnPause;
    private javax.swing.JButton jbnRemove;
    private javax.swing.JButton jbnResume;
    private javax.swing.JTable jtbDownload;
    private javax.swing.JTextField jtxURL;
    // End of variables declaration//GEN-END:variables
}
