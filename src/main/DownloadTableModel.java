package main;

import java.time.LocalDateTime;
import main.DownloadManager;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JProgressBar;
import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel implements Observer {
    
	private static final long serialVersionUID = -7852567715605820609L;
    private static final String[] columnNames = {"URL", "File (KB)","Progress", "Status"};
    @SuppressWarnings("rawtypes")
	private static final Class[] columnClasses = {String.class,
    	String.class, JProgressBar.class, String.class};
    
    public void addNewDownload(Downloader download) {
        download.addObserver(this);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
    
    public void clearDownload(int row) {        
        fireTableRowsDeleted(row, row);
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int col) {
        return columnClasses[col];
    }
    public int getRowCount() {
        return DownloadManager.getInstance().getDownloadList().size();
    }
    public Object getValueAt(int row, int col) {
        Downloader download = DownloadManager.getInstance().getDownloadList().get(row);
        
        switch (col) {
            case 0: // URL
                return download.getURL();
            case 1: // Size
                int size = download.getFileSize();
                return (size == -1) ? "" : download.getURL().substring(download.getURL().lastIndexOf('/') + 1)+" ("+(Integer.toString(size/1000)+"KB)");
            case 2: // Progress
                return new Float(download.getProgress());
            case 3: // Status
                String state;
                if(Downloader.STATUSES[download.getState()]=="Complete"){
                    state = "Downloaded on " + LocalDateTime.now();
                }
                else{
                    state = Downloader.STATUSES[download.getState()];
                }
                return state;
        }
        return "";
    }
    public void update(Observable o, Object arg) {
        int index = DownloadManager.getInstance().getDownloadList().indexOf(o);
        fireTableRowsUpdated(index, index);
    }
}