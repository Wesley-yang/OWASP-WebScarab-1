/***********************************************************************
 *
 * $CVSHeader$
 *
 * This file is part of WebScarab, an Open Web Application Security
 * Project utility. For details, please see http://www.owasp.org/
 *
 * Copyright (c) 2002 - 2004 Rogan Dawes
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Getting Source
 * ==============
 *
 * Source for this application is maintained at Sourceforge.net, a
 * repository for free software projects.
 * 
 * For details, please see http://www.sourceforge.net/projects/owasp
 *
 */

/*
 * CookieJarViewer.java
 *
 * Created on September 30, 2003, 10:08 PM
 */

package org.owasp.webscarab.ui.swing;

import org.owasp.webscarab.model.Cookie;
import org.owasp.webscarab.model.SiteModelAdapter;
import org.owasp.webscarab.model.SiteModel;
import org.owasp.webscarab.model.SiteModelListener;

import org.owasp.webscarab.util.swing.TableSorter;

import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author  rdawes
 */
public class CookieJarViewer extends javax.swing.JFrame {
    
    private CookieTableModel _cookieTableModel = new CookieTableModel(null);
    private HistoricalCookieTableModel _detailTableModel = new HistoricalCookieTableModel(null);
    
    private Logger _logger = Logger.getLogger(getClass().getName());
    
    /** Creates new form CookieJarViewer */
    public CookieJarViewer() {
        initComponents();
        cookieTable.setModel(new TableSorter(_cookieTableModel, cookieTable.getTableHeader()));
        cookieDetailTable.setModel(new TableSorter(_detailTableModel, cookieDetailTable.getTableHeader()));
        cookieTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) return;
                int row = cookieTable.getSelectedRow();
                if (row>-1) {
                    String key = _cookieTableModel.getKeyAt(row);
                    _logger.info("Key at row " + row + " is " + key);
                    _detailTableModel.setKey(key);
                } else {
                    _detailTableModel.setKey(null);
                }
            }
        });
    }
    
    public void setModel(SiteModel model) {
        _cookieTableModel.setModel(model);
        _detailTableModel.setModel(model);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cookieTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cookieDetailTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("WebScarab Cookies");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setText("Cookies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 200));
        cookieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(cookieTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel2.setText("Previous values");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 200));
        cookieDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(cookieDetailTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(closeButton, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(addButton, gridBagConstraints);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(deleteButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }//GEN-END:initComponents
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        _detailTableModel.deleteCookieAt(cookieDetailTable.getSelectedRow());
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
    }//GEN-LAST:event_exitForm
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTable cookieDetailTable;
    private javax.swing.JTable cookieTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    private class CookieTableModel extends AbstractTableModel {
        
        private SiteModel _model = null;
        private SiteModelListener _listener = new SiteModelAdapter() {
            public void cookieAdded(Cookie cookie) {
                int row = _model.getIndexOfCookie(cookie);
                int count = _model.getCookieCount(cookie.getKey());
                if (count == 1) {
                    fireTableRowsInserted(row, row);
                } else {
                    fireTableRowsUpdated(row, row);
                }
            }
            
            public void cookieRemoved(Cookie cookie) {
                int count = _model.getCookieCount(cookie.getKey());
                if (count == 0) {
                    fireTableDataChanged();
                } else {
                    int row = _model.getIndexOfCookie(cookie);
                    fireTableRowsUpdated(row, row);
                }
            }
        };
        
        private String[] _columnNames = new String[] { "Domain", "Path", "Name", "Date", "Value", "Secure", "Max age", "Comment" };
        private Class[] _columnClass = new Class[] { String.class, String.class, String.class, Date.class, String.class, Boolean.class, String.class, String.class };
        
        public CookieTableModel(SiteModel model) {
            setModel(model);
        }
        
        public void setModel(SiteModel model) {
            if (_model != null)
                _model.removeSiteModelListener(_listener);
            _model = model;
            if (_model != null) {
                _model.addSiteModelListener(_listener);
            }
            fireTableDataChanged();
        }
        
        public int getColumnCount() {
            return _columnNames.length;
        }
        
        public int getRowCount() {
            if (this._model == null) return 0;
            return _model.getCookieCount();
        }
        
        public Object getValueAt(int rowIndex, int columnIndex) {
            String key = _model.getCookieAt(rowIndex);
            Cookie cookie = _model.getCurrentCookie(key);
            switch (columnIndex) {
                case 0: return cookie.getDomain();
                case 1: return cookie.getPath();
                case 2: return cookie.getName();
                case 3: return cookie.getDate();
                case 4: return cookie.getValue();
                case 5: return Boolean.valueOf(cookie.getSecure());
                case 6: return cookie.getMaxAge();
                case 7: return cookie.getComment();
            }
            return null;
        }
        
        public String getColumnName(int columnIndex) {
            return _columnNames[columnIndex];
        }
        
        public Class getColumnClass(int columnIndex) {
            return _columnClass[columnIndex];
        }
        
        public String getKeyAt(int row) {
            return _model.getCookieAt(row);
        }
        
    }
    
    private class HistoricalCookieTableModel extends AbstractTableModel {
        
        private SiteModel _model = null;
        private String _key = null;
        
        private SiteModelListener _listener = new SiteModelAdapter() {
            public void cookieAdded(Cookie cookie) {
                if (_key == null || ! _key.equals(cookie.getKey())) return;
                int row = _model.getIndexOfCookie(_key, cookie);
                fireTableRowsInserted(row, row);
            }
            
            public void cookieRemoved(Cookie cookie) {
                if (_key == null || ! _key.equals(cookie.getKey())) return;
                fireTableDataChanged();
            }
        };
        
        private String[] _columnNames = new String[] { "Date", "Value", "Secure", "Max age", "Comment" };
        private Class[] _columnClass = new Class[] { Date.class, String.class, Boolean.class, String.class, String.class };
        
        public HistoricalCookieTableModel(SiteModel model) {
            setModel(model);
        }
        
        public void setModel(SiteModel model) {
            _key = null;
            if (_model != null)
                _model.removeSiteModelListener(_listener);
            _model = model;
            if (_model != null) {
                _model.addSiteModelListener(_listener);
            }
            fireTableDataChanged();
        }
        
        public void setKey(String key) {
            _key = key;
            fireTableDataChanged();
        }
        
        public int getRowCount() {
            if (this._model == null) return 0;
            if (_key == null) return 0;
            return this._model.getCookieCount(_key);
        }
        
        public Object getValueAt(int row, int column) {
            Cookie cookie = _model.getCookieAt(_key, row);
            switch (column) {
                case 0: return cookie.getDate();
                case 1: return cookie.getValue();
                case 2: return Boolean.valueOf(cookie.getSecure());
                case 3: return cookie.getMaxAge();
                case 4: return cookie.getComment();
            }
            return null;
        }
        
        public int getColumnCount() {
            return _columnNames.length;
        }
        
        public String getColumnName(int columnIndex) {
            return _columnNames[columnIndex];
        }
        
        public Class getColumnClass(int columnIndex) {
            return _columnClass[columnIndex];
        }
        
        public void deleteCookieAt(int row) {
            if (row < getRowCount() && row > -1) {
                Cookie cookie = _model.getCookieAt(_key, row);
                _model.removeCookie(cookie);
            }
        }
        
    }
}
