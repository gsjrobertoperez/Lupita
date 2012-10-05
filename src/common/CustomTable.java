/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Luc3
 */
public class CustomTable extends JTable {

    ListSelectionModel listSelection;
    Integer selectedIndex;
    ArrayList objectArray;
 
    public CustomTable() {
        super();
        this.setShowHorizontalLines(true);
        this.setShowVerticalLines(false);
        listSelection = this.getSelectionModel();
        listSelection.addListSelectionListener(new SharedListSelectionHandler());
        this.setSelectionModel(listSelection);
        objectArray = new ArrayList();
        this.setDragEnabled(false);
        this.setColumnSelectionAllowed(false);
        this.setRowSelectionAllowed(true);
        this.getTableHeader().setReorderingAllowed(false);
        //setPreferredScrollableViewportSize(new Dimension(500, 70));
        setFillsViewportHeight(true);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int colIndex){
        return false;
    }

    public ArrayList getObjectArray(){
        return objectArray;
    }

    public void setObjectArray(ArrayList obj){
        this.objectArray = obj;
    }

    public void setTableModel(Object[] columns, Object[][] rows) {
        DefaultTableModel model = new DefaultTableModel(rows, columns);
        this.setModel(model);
    }

   public void setTableModel(DefaultTableModel model) {
        this.setModel(model);
    }

   /**
     * Paints empty rows too, after letting the UI delegate do
     * its painting.
     */
    public void paint(Graphics g) {
        super.paint(g);
        paintEmptyRows(g);
    }

    /**
     * Paints the backgrounds of the implied empty rows when the
     * table model is insufficient to fill all the visible area
     * available to us. We don't involve cell renderers, because
     * we have no data.
     */
    protected void paintEmptyRows(Graphics g) {
        final int rowCount = getRowCount();
        final Rectangle clip = g.getClipBounds();
        if (rowCount * rowHeight < clip.height) {
            for (int i = rowCount; i <= clip.height/rowHeight; ++i) {
                g.setColor(colorForRow(i));
                g.fillRect(clip.x, i * rowHeight, clip.width, rowHeight);
            }
        }
    }

    /**
     * Changes the behavior of a table in a JScrollPane to be more like
     * the behavior of JList, which expands to fill the available space.
     * JTable normally restricts its size to just what's needed by its
     * model.
     */
    public boolean getScrollableTracksViewportHeight() {
        if (getParent() instanceof JViewport) {
            JViewport parent = (JViewport) getParent();
            return (parent.getHeight() > getPreferredSize().height);
        }
        return false;
    }

    /**
     * Returns the appropriate background color for the given row.
     */
    protected Color colorForRow(int row) {
        return (row % 2 == 0) ? new Color(215,215,215) : getBackground();
    }

    /**
     * Shades alternate rows in different colors.
     */
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isCellSelected(row, column) == false) {
            c.setBackground(colorForRow(row));
            c.setForeground(UIManager.getColor("Table.foreground"));
        } else {
            c.setBackground(UIManager.getColor("Table.selectionBackground"));
            c.setForeground(UIManager.getColor("Table.selectionForeground"));
        }
        return c;
    }

    public Integer getSelectedIndex() {
        
        return this.selectedIndex;
    }

    class SharedListSelectionHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (!lsm.isSelectionEmpty()) {
                // Find out which indexes are selected.
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        selectedIndex = i;
                    }
                }
            }
        }
    }
}
