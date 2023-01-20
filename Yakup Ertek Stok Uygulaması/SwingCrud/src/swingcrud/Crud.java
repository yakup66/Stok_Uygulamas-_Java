package swingcrud;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Crud extends javax.swing.JFrame {
	
	Connection con;
    Statement st;
    ArrayList<Stok> stok = new ArrayList<>();

    public Crud() {
        initComponents();
        fetch();
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

    	txtStokKodu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        
        jLabel2 = new javax.swing.JLabel();
        txtStokAdi = new javax.swing.JTextField();
        
        txtStokTipi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        
        txtStokBirim = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        
        txtStokBarkod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        
        txtStokKdv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        
        
        txtStokAciklama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        
     
        txtStokTarih = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stok Uygulamam");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel1.setText("Stok Kodu");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel2.setText("Stok Adi");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel3.setText("Stok Tipi");
        
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel5.setText("Stok Birim");
        
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel6.setText("Stok Barkod");
        
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel7.setText("Stok Kdv");
        
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel8.setText("Açıklama");
        
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); 
        jLabel9.setText("Tarih");

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stok Kodu", "Stok Adı", "Stok Birim","Stok Barkod", "Stok Tip", "Stok Kdv","Açıklama", "Tarih"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.setCellSelectionEnabled(true);
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSave.setText("Kayıt Ekle");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Güncelle");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("Sil");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        
        btnList.setText("Listele");
        btnList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnListActionPerformed(evt);
                
            }

			
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Stok Uygulaması");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            
                        		.addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokBirim, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokKdv, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    
                    
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                        
                        .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                
                        
                        .addGap(27, 27, 27)
                        
                
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStokKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStokAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtStokBirim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStokBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtStokTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtStokKdv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStokAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtStokTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(30, 30, 30)
                                        
                                    
                       
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
       
    	String stok_kodu = txtStokKodu.getText().trim();
        String stok_adi = txtStokAdi.getText().trim();
        String stok_tipi = txtStokTipi.getText().trim();
        String stok_birim = txtStokBirim.getText().trim();
        String stok_barkod = txtStokBarkod.getText().trim();
        String stok_kdv = txtStokKdv.getText().trim();
        String stok_aciklama = txtStokAciklama.getText().trim();
        String stok_tarih = txtStokTarih.getText().trim();
        
        if (!stok_kodu.isEmpty() && !stok_adi.isEmpty() && !stok_tipi.isEmpty()) {
            try {
            
                try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String sql = "select * from project where stok_kodu='" + stok_kodu + "'";
                try {
					st = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                ResultSet rs = null;
				try {
					rs = st.executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					if (!rs.first()) {
					    saveUser(stok_kodu, stok_adi, stok_tipi,stok_birim,stok_barkod,stok_kdv,stok_aciklama,stok_tarih);
					    DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
					    Object[] row = new Object[8];
					    row[0] = stok_kodu;
					    row[1] = stok_adi;
					    row[2] = stok_tipi;
					    row[3] = stok_birim;
					    row[4] = stok_barkod;
					    row[5] = stok_kdv;
					    row[6] = stok_aciklama;
					    row[7] = stok_tarih;
					    
					    model.addRow(row);
					} else {
					    alert("Lütfen farklı bir kimlik numarası verin");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}

                clear();
            }  finally {
                try {
                    con.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
         
        else {
            alert("Lütfen tüm alanları doldurunuz");
        }
    }
    
    private void btnListActionPerformed(ActionEvent evt) {
		
    	try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
			st = con.createStatement();
			String sql = "select stok_kodu , stok_adi , stok_tipi , stok_birim , stok_barkod , stok_kdv , stok_aciklama , stok_tarih from project where stok_kodu=";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
				 Object[] row = new Object[8];
				    row[0] = rs.getString("stok_kodu");
				    row[1] = rs.getString("stok_adi");
				    row[2] = rs.getString("stok_tipi");
				    row[3] = rs.getString("stok_birim");
				    row[4] = rs.getString("stok_barkod");
				    row[5] = rs.getString("stok_kdv");
				    row[6] = rs.getString("stok_aciklama");
				    row[7] =rs.getString("stok_tarih");
				    
				    model.addRow(row);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
       
    	String stok_kodu = txtStokKodu.getText().trim();
        String stok_adi = txtStokAdi.getText().trim();
        String stok_tipi = txtStokTipi.getText().trim();
        String stok_birim = txtStokBirim.getText().trim();
        String stok_barkod = txtStokBarkod.getText().trim();
        String stok_kdv = txtStokKdv.getText().trim();
        String stok_aciklama = txtStokAciklama.getText().trim();
        String stok_tarih = txtStokTarih.getText().trim();
        if (!stok_kodu.isEmpty() && !stok_adi.isEmpty() && !stok_tipi.isEmpty()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
                String sql = "select * from project where stok_kodu='" + stok_kodu + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.first()) {
                    update(stok_kodu, stok_adi, stok_tipi,stok_birim,stok_barkod,stok_kdv,stok_aciklama,stok_tarih);
                    DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
                    model.setRowCount(0);                   
                    fetch();
                    alert("Güncelleme başarılı oldu");
                    
                } else {
                    alert("Böyle bir stok yok  Güncelleme hatası");
                    clear();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alert("Güncellenecek bir şey yok ");
        }
    }

   
    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {
        
        int i = tblStudents.getSelectedRow();
        TableModel model = tblStudents.getModel();
        txtStokKodu.setText(model.getValueAt(i, 0).toString());
        txtStokAdi.setText(model.getValueAt(i, 1).toString());
        txtStokBirim.setText(model.getValueAt(i, 2).toString());
        txtStokBarkod.setText(model.getValueAt(i, 3).toString());
        txtStokKdv.setText(model.getValueAt(i, 4).toString());
        txtStokAciklama.setText(model.getValueAt(i, 5).toString());
        txtStokTarih.setText(model.getValueAt(i, 6).toString());
    }

    
    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int i = tblStudents.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Silmek istediğine emin misin?", getTitle(), JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblStudents.getModel();

                String id = model.getValueAt(i, 2).toString();
                if (tblStudents.getSelectedRows().length == 1) {
                    delete(id);
                    DefaultTableModel model1 = (DefaultTableModel) tblStudents.getModel();
                    model1.setRowCount(0);
                    fetch();
                    clear();
                }
            }
        } else {
            alert("Lütfen silinecek bir satır seçin");
        }
    }
    
    
    

   
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

  
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

   
    public void saveUser(String stok_kodu , String stok_adi , String stok_tipi , String stok_birim, String stok_barkod, String stok_kdv, String stok_aciklama, String stok_tarih) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
            String sql = "INSERT INTO `project`(`stok_kodu`, `stok_adi`, `stok_tipi`, `stok_birim`, `stok_barkod`, `stok_kdv`, `stok_aciklama`, `stok_tarih`) "
                    + "VALUES ('" + stok_kodu + "','" + stok_adi + "','" + stok_tipi + "','" + stok_birim + "','" + stok_barkod +  "','" + stok_kdv +  "','" + stok_aciklama  +  "','" + stok_tarih +"')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void update(String stok_kodu , String stok_adi , String stok_tipi , String stok_birim, String stok_barkod, String stok_kdv, String stok_aciklama, String stok_tarih) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
            String sql = "UPDATE `project`SET stok_kodu='" + stok_kodu + "',stok_adi='" + stok_adi +  "',stok_tipi='" + stok_tipi +
            		 "',stok_birim='" + stok_birim+ "',stok_barkod='" + stok_barkod+ "',stok_kdv='" + stok_kdv+  "',stok_aciklama='" + stok_aciklama +  "',stok_tarih='" +stok_tarih 
            		+"'WHERE stok_kodu='" + stok_kodu + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void delete(String stok_kodu) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
            String sql = "DELETE FROM `project` WHERE stok_kodu='" + stok_kodu + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    private void clear() {
    	txtStokKodu.setText("");
    	txtStokAdi.setText("");
    	txtStokTipi.setText("");
    	txtStokBirim.setText("");
        txtStokBarkod.setText("");
        txtStokKdv.setText("");
        txtStokAciklama.setText("");
        txtStokTarih.setText("");
    }

 
    private void fetch() {
        stok.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "toor");
            String sql = "select * from project";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Stok stok = new Stok(rs.getString("stok_kodu"), rs.getString("stok_adi"), rs.getString("stok_tipi"), rs.getString("stok_birim"), rs.getString("stok_barkod"), rs.getString("stok_kdv"), rs.getString("stok_aciklama"), rs.getString("stok_tarih"));
                stok.addAll((Collection<? extends Stok>) stok);
            }
            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
            for (Stok stoks : stok) {

                Object[] row = new Object[8];
                row[0] = stoks.getStok_kodu();
                row[1] = stoks.getStok_adi();
                row[2] = stoks.getStok_tipi();
                row[3] = stoks.getStok_birim();
                row[4] = stoks.getStok_barkod();
                row[5] = stoks.getStok_kdv();
                row[6] = stoks.getStok_aciklama();
                row[7] = stoks.getStok_tarih();
                

                model.addRow(row);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new Crud().setVisible(true);
        });
    }

  
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnList;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;

    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudents;
    
    private javax.swing.JTextField txtStokKodu;
    private javax.swing.JTextField txtStokTipi;
    private javax.swing.JTextField txtStokAdi;
    private javax.swing.JTextField txtStokBirim;
    private javax.swing.JTextField txtStokBarkod;
    private javax.swing.JTextField txtStokKdv;
    private javax.swing.JTextField txtStokAciklama;
    private javax.swing.JTextField txtStokTarih;
   
}
