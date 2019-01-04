/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Adrian
 */
public class CarteDeTelefon extends javax.swing.JFrame implements Serializable {
        private Thread t;
        public  File f = null;
        private List<ImageIcon> reclama = new ArrayList<ImageIcon>();
        private int reclamaCurenta;
        
        private List<Abonat> abonati = new ArrayList<>();
        private int abonatCurent;
        
    /**
     * 
     * Creates new form CarteDeTelefon
     */
    public CarteDeTelefon() {
        initComponents();
        mOpen.setEnabled(false);
        mSave.setEnabled(false);
        t= new Thread(){
        @Override
        public void run() {
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("reclama1.jpg"));
        ImageIcon i2 = new ImageIcon(getClass().getResource("reclama2.jpg"));
        ImageIcon i3 = new ImageIcon(getClass().getResource("reclama3.jpg"));
        ImageIcon i4 = new ImageIcon(getClass().getResource("reclama4.jpg"));
        ImageIcon[] reclame = {i1,i2,i3,i4};
        reclama = Arrays.asList(reclame);
        ImageIcon f =  reclama.get(reclamaCurenta);
        label.setIcon(f);
                
                while(true){
                    reclamaCurenta = ++reclamaCurenta % reclama.size();
                         f =  reclama.get(reclamaCurenta);
                    label.setIcon(f);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        return;
                    } }
                }
                };
                    t.start();
                    
             ActionListener task = new ActionListener(){
                 
                 public void actionPerformed(ActionEvent e){
                     FileOutputStream fos = null;
                     
                     
                     if(f != null){
                         
                         try{
                            
                             
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(abonati);
                oos.close();
                fos.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
                     
            }
                         }
                     }
                     }
                 };
                    
                    
                    Timer tr = new Timer(300000,task);
                    tr.start();
        
         
    
    
    KeyStroke ctrlXKeyStrokeOpen = KeyStroke.getKeyStroke("control O");
    mOpen.setAccelerator(ctrlXKeyStrokeOpen);
    
    
    KeyStroke ctrlXKeyStrokeSave = KeyStroke.getKeyStroke("control S");
    mSave.setAccelerator(ctrlXKeyStrokeSave);
    
    
    KeyStroke ctrlXKeyStrokeAd = KeyStroke.getKeyStroke("control N");
    mAdauga.setAccelerator(ctrlXKeyStrokeAd);
   
    
    KeyStroke ctrlXKeyStrokeMod = KeyStroke.getKeyStroke("control M");
    mModifica.setAccelerator(ctrlXKeyStrokeMod);
    
    
    KeyStroke ctrlXKeyStrokeDelete = KeyStroke.getKeyStroke("control D");
    mSterge.setAccelerator(ctrlXKeyStrokeDelete);
    mAbonati.add(mSterge);
    
    KeyStroke ctrlXKeyStrokeCauta = KeyStroke.getKeyStroke("control F");
    mCauta.setAccelerator(ctrlXKeyStrokeCauta);
   
    
    KeyStroke ctrlXKeyStrokeInreg = KeyStroke.getKeyStroke("control I");
    mInregistrare.setAccelerator(ctrlXKeyStrokeInreg);
   
    
    
    
    bAdauga.setMnemonic(KeyEvent.VK_A);
    bCautare.setMnemonic(KeyEvent.VK_C);
    bModifica.setMnemonic(KeyEvent.VK_M);
    bIesire.setMnemonic(KeyEvent.VK_I);
    bSortare.setMnemonic(KeyEvent.VK_O);
     bSterge.setMnemonic(KeyEvent.VK_DELETE);
  
    InputMap im = bDa.getInputMap();
    im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
    im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
    
    InputMap im1 = bDa1.getInputMap();
    im1.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
    im1.put(KeyStroke.getKeyStroke("released ENTER"), "released");
    
    
    
    
    Action action1 = new AbstractAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        bValidare.doClick();
        bModifica1.doClick();
      
    }
};
    
    Action action = new AbstractAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        bPass.doClick();
        bCauta.doClick();

    }
};
    tfPass.addActionListener(action);
    tfNume.addActionListener(action1);
    tfPrenume.addActionListener(action1);
    tfCNP.addActionListener(action1);
    tfNrTel.addActionListener(action1);
    tfCautare.addActionListener(action);
    tfNume1.addActionListener(action1);
    tfPrenume1.addActionListener(action1);
    tfCNP1.addActionListener(action1);
    tfNrTel1.addActionListener(action1);
    
    
    
    }

    

           
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        dAdauga = new javax.swing.JDialog();
        panel = new javax.swing.JPanel();
        lNume = new javax.swing.JLabel();
        lPrenume = new javax.swing.JLabel();
        lCNP = new javax.swing.JLabel();
        lNrTel = new javax.swing.JLabel();
        tfNume = new javax.swing.JTextField();
        tfPrenume = new javax.swing.JTextField();
        tfCNP = new javax.swing.JTextField();
        tfNrTel = new javax.swing.JTextField();
        bValidare = new javax.swing.JButton();
        dOrdoneaza = new javax.swing.JDialog();
        sp = new javax.swing.JScrollPane();
        tSortare = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rbNume = new javax.swing.JRadioButton();
        rbPrenume = new javax.swing.JRadioButton();
        rbCNP = new javax.swing.JRadioButton();
        rbNrTel = new javax.swing.JRadioButton();
        bOrdoneaza = new javax.swing.JButton();
        lOrdonare = new javax.swing.JLabel();
        bg = new javax.swing.ButtonGroup();
        dIesire = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        bDa = new javax.swing.JButton();
        bNu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dAbout = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        dModifica = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        lNume1 = new javax.swing.JLabel();
        lPrenume1 = new javax.swing.JLabel();
        lCNP1 = new javax.swing.JLabel();
        lNrTel1 = new javax.swing.JLabel();
        tfNume1 = new javax.swing.JTextField();
        tfPrenume1 = new javax.swing.JTextField();
        tfCNP1 = new javax.swing.JTextField();
        tfNrTel1 = new javax.swing.JTextField();
        bModifica1 = new javax.swing.JButton();
        dPass = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        bPass = new javax.swing.JButton();
        dCautare = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCautare = new javax.swing.JTable();
        tfCautare = new javax.swing.JTextField();
        bCauta = new javax.swing.JButton();
        dSterge = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        bDa1 = new javax.swing.JButton();
        bNu1 = new javax.swing.JButton();
        lSterge = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bCautare = new javax.swing.JButton();
        bAdauga = new javax.swing.JButton();
        bIesire = new javax.swing.JButton();
        bSortare = new javax.swing.JButton();
        bSterge = new javax.swing.JButton();
        bModifica = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAfisare = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        mOpen = new javax.swing.JMenuItem();
        mSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mIesire = new javax.swing.JMenuItem();
        mAbonati = new javax.swing.JMenu();
        mAdauga = new javax.swing.JMenuItem();
        mCauta = new javax.swing.JMenuItem();
        mSterge = new javax.swing.JMenuItem();
        mModifica = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        mInregistrare = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mAbout = new javax.swing.JMenuItem();

        dAdauga.setResizable(false);
        dAdauga.setSize(new java.awt.Dimension(350, 300));

        panel.setBackground(new java.awt.Color(102, 102, 102));
        panel.setForeground(new java.awt.Color(0, 0, 0));

        lNume.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lNume.setForeground(new java.awt.Color(0, 0, 0));
        lNume.setText("Nume");

        lPrenume.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lPrenume.setForeground(new java.awt.Color(0, 0, 0));
        lPrenume.setText("Prenume");

        lCNP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lCNP.setForeground(new java.awt.Color(0, 0, 0));
        lCNP.setText("CNP");

        lNrTel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lNrTel.setForeground(new java.awt.Color(0, 0, 0));
        lNrTel.setText("Nr. Telefon");

        bValidare.setBackground(new java.awt.Color(51, 255, 51));
        bValidare.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bValidare.setForeground(new java.awt.Color(0, 0, 0));
        bValidare.setText("Validare");
        bValidare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValidareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(bValidare, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lNrTel)
                            .addComponent(lCNP)
                            .addComponent(lPrenume)
                            .addComponent(lNume))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNume)
                            .addComponent(tfPrenume)
                            .addComponent(tfCNP)
                            .addComponent(tfNrTel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNume)
                    .addComponent(tfNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrenume)
                    .addComponent(tfPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCNP)
                    .addComponent(tfCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNrTel)
                    .addComponent(tfNrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(bValidare, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout dAdaugaLayout = new javax.swing.GroupLayout(dAdauga.getContentPane());
        dAdauga.getContentPane().setLayout(dAdaugaLayout);
        dAdaugaLayout.setHorizontalGroup(
            dAdaugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dAdaugaLayout.setVerticalGroup(
            dAdaugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dOrdoneaza.setSize(new java.awt.Dimension(400, 370));

        sp.setBackground(new java.awt.Color(102, 102, 102));
        sp.setForeground(new java.awt.Color(0, 0, 0));

        tSortare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nume", "Prenume", "CNP", "Nr. Telefon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sp.setViewportView(tSortare);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        rbNume.setBackground(new java.awt.Color(102, 102, 102));
        bg.add(rbNume);
        rbNume.setForeground(new java.awt.Color(0, 0, 0));
        rbNume.setText("Nume");
        rbNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNumeActionPerformed(evt);
            }
        });

        rbPrenume.setBackground(new java.awt.Color(102, 102, 102));
        bg.add(rbPrenume);
        rbPrenume.setForeground(new java.awt.Color(0, 0, 0));
        rbPrenume.setText("Prenume");

        rbCNP.setBackground(new java.awt.Color(102, 102, 102));
        bg.add(rbCNP);
        rbCNP.setForeground(new java.awt.Color(0, 0, 0));
        rbCNP.setText("CNP");

        rbNrTel.setBackground(new java.awt.Color(102, 102, 102));
        bg.add(rbNrTel);
        rbNrTel.setForeground(new java.awt.Color(0, 0, 0));
        rbNrTel.setText("Nr. Telefon");

        bOrdoneaza.setBackground(new java.awt.Color(255, 255, 0));
        bOrdoneaza.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bOrdoneaza.setForeground(new java.awt.Color(0, 0, 0));
        bOrdoneaza.setText("Ordoneaza");
        bOrdoneaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdoneazaActionPerformed(evt);
            }
        });

        lOrdonare.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lOrdonare.setForeground(new java.awt.Color(0, 0, 0));
        lOrdonare.setText("Ordoneaza dupa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbNrTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lOrdonare)
                        .addGap(178, 178, 178))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(rbNume)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbPrenume)
                                .addComponent(rbCNP))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bOrdoneaza))))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lOrdonare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbPrenume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCNP))
                    .addComponent(bOrdoneaza, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNrTel)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dOrdoneazaLayout = new javax.swing.GroupLayout(dOrdoneaza.getContentPane());
        dOrdoneaza.getContentPane().setLayout(dOrdoneazaLayout);
        dOrdoneazaLayout.setHorizontalGroup(
            dOrdoneazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dOrdoneazaLayout.setVerticalGroup(
            dOrdoneazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dOrdoneazaLayout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dIesire.setBackground(new java.awt.Color(102, 102, 102));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        bDa.setBackground(new java.awt.Color(0, 204, 0));
        bDa.setText("DA");
        bDa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDaActionPerformed(evt);
            }
        });

        bNu.setBackground(new java.awt.Color(255, 0, 0));
        bNu.setText("NU");
        bNu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Doriti sa parasiti aplicatia?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bDa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(bNu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dIesireLayout = new javax.swing.GroupLayout(dIesire.getContentPane());
        dIesire.getContentPane().setLayout(dIesireLayout);
        dIesireLayout.setHorizontalGroup(
            dIesireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dIesireLayout.setVerticalGroup(
            dIesireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dAbout.setBackground(new java.awt.Color(51, 51, 51));
        dAbout.setSize(new java.awt.Dimension(322, 160));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\nPhoneBook\nCreated by Barcan Adrian\n");
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dAboutLayout = new javax.swing.GroupLayout(dAbout.getContentPane());
        dAbout.getContentPane().setLayout(dAboutLayout);
        dAboutLayout.setHorizontalGroup(
            dAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dAboutLayout.setVerticalGroup(
            dAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dModifica.setSize(new java.awt.Dimension(400, 300));

        lNume1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lNume1.setForeground(new java.awt.Color(0, 0, 0));
        lNume1.setText("Nume");

        lPrenume1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lPrenume1.setForeground(new java.awt.Color(0, 0, 0));
        lPrenume1.setText("Prenume");

        lCNP1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lCNP1.setForeground(new java.awt.Color(0, 0, 0));
        lCNP1.setText("CNP");

        lNrTel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lNrTel1.setForeground(new java.awt.Color(0, 0, 0));
        lNrTel1.setText("Nr. Telefon");

        bModifica1.setBackground(new java.awt.Color(51, 255, 51));
        bModifica1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bModifica1.setForeground(new java.awt.Color(0, 0, 0));
        bModifica1.setText("Modifica");
        bModifica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifica1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(bModifica1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lNrTel1)
                            .addComponent(lCNP1)
                            .addComponent(lPrenume1)
                            .addComponent(lNume1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNume1)
                            .addComponent(tfPrenume1)
                            .addComponent(tfCNP1)
                            .addComponent(tfNrTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNume1)
                    .addComponent(tfNume1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrenume1)
                    .addComponent(tfPrenume1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCNP1)
                    .addComponent(tfCNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNrTel1)
                    .addComponent(tfNrTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(bModifica1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout dModificaLayout = new javax.swing.GroupLayout(dModifica.getContentPane());
        dModifica.getContentPane().setLayout(dModificaLayout);
        dModificaLayout.setHorizontalGroup(
            dModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dModificaLayout.setVerticalGroup(
            dModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dPass.setSize(new java.awt.Dimension(363, 156));

        jLabel2.setText("Introduceti parola");

        tfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPassActionPerformed(evt);
            }
        });

        bPass.setText("OK");
        bPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(bPass)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bPass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dPassLayout = new javax.swing.GroupLayout(dPass.getContentPane());
        dPass.getContentPane().setLayout(dPassLayout);
        dPassLayout.setHorizontalGroup(
            dPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dPassLayout.setVerticalGroup(
            dPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dCautare.setSize(new java.awt.Dimension(392, 322));

        tCautare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tCautare);

        bCauta.setText("Cauta");
        bCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCautaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(tfCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(bCauta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tfCautare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCauta)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout dCautareLayout = new javax.swing.GroupLayout(dCautare.getContentPane());
        dCautare.getContentPane().setLayout(dCautareLayout);
        dCautareLayout.setHorizontalGroup(
            dCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dCautareLayout.setVerticalGroup(
            dCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dSterge.setSize(new java.awt.Dimension(336, 149));

        bDa1.setText("DA");
        bDa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDa1ActionPerformed(evt);
            }
        });

        bNu1.setText("NU");
        bNu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lSterge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(bDa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(bNu1)))
                .addGap(70, 70, 70))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lSterge, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDa1)
                    .addComponent(bNu1))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout dStergeLayout = new javax.swing.GroupLayout(dSterge.getContentPane());
        dSterge.getContentPane().setLayout(dStergeLayout);
        dStergeLayout.setHorizontalGroup(
            dStergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dStergeLayout.setVerticalGroup(
            dStergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(600, 200));
        setResizable(false);

        label.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        bCautare.setBackground(new java.awt.Color(153, 153, 153));
        bCautare.setText("Cautare");
        bCautare.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bCautare.setBorderPainted(false);
        bCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCautareActionPerformed(evt);
            }
        });

        bAdauga.setBackground(new java.awt.Color(153, 153, 153));
        bAdauga.setText("Adauga");
        bAdauga.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bAdauga.setBorderPainted(false);
        bAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });

        bIesire.setBackground(new java.awt.Color(153, 153, 153));
        bIesire.setText("Iesire");
        bIesire.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bIesire.setBorderPainted(false);
        bIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIesireActionPerformed(evt);
            }
        });

        bSortare.setBackground(new java.awt.Color(153, 153, 153));
        bSortare.setText("Sortare");
        bSortare.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bSortare.setBorderPainted(false);
        bSortare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSortareActionPerformed(evt);
            }
        });

        bSterge.setBackground(new java.awt.Color(153, 153, 153));
        bSterge.setText("Sterge");
        bSterge.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bSterge.setBorderPainted(false);
        bSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeActionPerformed(evt);
            }
        });

        bModifica.setBackground(new java.awt.Color(153, 153, 153));
        bModifica.setText("Modifica");
        bModifica.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bModifica.setBorderPainted(false);
        bModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSortare, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSterge, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bModifica, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(bIesire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSterge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSortare, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(bCautare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bIesire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tAfisare.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tAfisare);

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));

        mFile.setText("File");

        mOpen.setText("Open");
        mOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpenActionPerformed(evt);
            }
        });
        mFile.add(mOpen);

        mSave.setText("Save");
        mSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveActionPerformed(evt);
            }
        });
        mFile.add(mSave);
        mFile.add(jSeparator1);

        mIesire.setText("Iesire");
        mIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIesireActionPerformed(evt);
            }
        });
        mFile.add(mIesire);

        jMenuBar1.add(mFile);

        mAbonati.setText("Abonati");
        mAbonati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeActionPerformed(evt);
            }
        });

        mAdauga.setText("Adauga...");
        mAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });
        mAbonati.add(mAdauga);

        mCauta.setText("Cauta...");
        mCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCautareActionPerformed(evt);
            }
        });
        mAbonati.add(mCauta);

        mSterge.setText("Sterge...");
        mSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeActionPerformed(evt);
            }
        });
        mAbonati.add(mSterge);

        mModifica.setText("Modifica...");
        mModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificaActionPerformed(evt);
            }
        });
        mAbonati.add(mModifica);

        jMenuBar1.add(mAbonati);

        mHelp.setText("Help");

        mInregistrare.setText("Inregistrare");
        mInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInregistrareActionPerformed(evt);
            }
        });
        mHelp.add(mInregistrare);
        mHelp.add(jSeparator2);

        mAbout.setText("About");
        mAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAboutActionPerformed(evt);
            }
        });
        mHelp.add(mAbout);

        jMenuBar1.add(mHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOpenActionPerformed
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            FileInputStream fis = null;
            try {
                File f = fc.getSelectedFile();
                fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                abonati = (List<Abonat>)ois.readObject();
                abonatCurent = 0;
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nume");
                model.addColumn("Prenume");
                model.addColumn("CNP");
                model.addColumn("Nr. Telefon");
                
                abonati.stream().forEach((a) -> {
                    model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
                });
                tAfisare.setModel(model);
                tSortare.setModel(model);
                tCautare.setModel(model);
            
                ois.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_mOpenActionPerformed

    private void mSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveActionPerformed
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            FileOutputStream fos = null;
            try {
                f = fc.getSelectedFile();
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(abonati);
                oos.close();
                fos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_mSaveActionPerformed

    private void rbNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNumeActionPerformed

    private void bIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIesireActionPerformed
        dIesire.setVisible(true);
        dIesire.setLocationRelativeTo(jPanel2);
        int width = 350;
        int height =150;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        dIesire.setBounds(x,y,width,height);
        
    }//GEN-LAST:event_bIesireActionPerformed

    private void bNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuActionPerformed
    dIesire.setVisible(false);
    }//GEN-LAST:event_bNuActionPerformed

    private void bDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bDaActionPerformed

    private void bAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaActionPerformed
      dAdauga.setVisible(true);
      dAdauga.setLocationRelativeTo(jPanel2);
    }//GEN-LAST:event_bAdaugaActionPerformed

    private void bSortareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortareActionPerformed
      dOrdoneaza.setVisible(true);
      dOrdoneaza.setLocationRelativeTo(jPanel2);
    }//GEN-LAST:event_bSortareActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
      dAbout.setVisible(true);
      dAbout.setLocationRelativeTo(jPanel2);
    }//GEN-LAST:event_mAboutActionPerformed

    private void bValidareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidareActionPerformed
       try{
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("CNP");
        model.addColumn("Nr. Telefon");
        
       NrTel n = new NrTel(tfNrTel.getText());
       Abonat ab = new Abonat(tfNume.getText(),tfPrenume.getText(),tfCNP.getText(),n);
       abonati.add(ab);
        for (Abonat a : abonati) {
            model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
        }
        tAfisare.setModel(model);
        tSortare.setModel(model);
        tCautare.setModel(model);
       }
       catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(
                    this,
                    "Date invalide!",
                    "EROARE",
                    JOptionPane.ERROR_MESSAGE
                    
            );
       }
    }//GEN-LAST:event_bValidareActionPerformed

    private void bStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStergeActionPerformed
        
        int ind=tAfisare.getSelectedRow();
        if(ind>0){
        
        dSterge.setVisible(true);
        dSterge.setLocationRelativeTo(jPanel2);
        
        int i=tAfisare.getSelectedRow();
        lSterge.setText("Doriti sa stergeti abonatul "+abonati.get(i).nume +" ?");
        }
        
        else{
           JOptionPane.showMessageDialog(
                    this,
                    "Selectati date!",
                    "EROARE",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bStergeActionPerformed

    private void bOrdoneazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdoneazaActionPerformed
        if (rbNume.isSelected()) {
            ordoneaza(CriteriuOrdonare.DUPA_NUME);
        }
        if (rbPrenume.isSelected()) {
            ordoneaza(CriteriuOrdonare.DUPA_PRENUME);
        }
        if (rbCNP.isSelected()) {
            ordoneaza(CriteriuOrdonare.DUPA_CNP);
        }
        if (rbNrTel.isSelected()) {
            ordoneaza(CriteriuOrdonare.DUPA_NRTEL);
        }
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("CNP");
        model.addColumn("Nr. Telefon");
        for (Abonat a : abonati) {
            model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
        }
        tAfisare.setModel(model);
        tSortare.setModel(model);
        tCautare.setModel(model);

    }//GEN-LAST:event_bOrdoneazaActionPerformed

    private void bModifica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifica1ActionPerformed
       try{
        int i=tAfisare.getSelectedRow();
         DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("CNP");
        model.addColumn("Nr. Telefon");
        
       NrTel n = new NrTel(tfNrTel1.getText());
       Abonat ab = new Abonat(tfNume1.getText(),tfPrenume1.getText(),tfCNP1.getText(),n);
       abonati.set(i,ab);
        for (Abonat a : abonati) {
            model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
        }
        tAfisare.setModel(model);
        tSortare.setModel(model);
        tCautare.setModel(model);
  }
       catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(
                    this,
                    "Date invalide!",
                    "EROARE",
                    JOptionPane.ERROR_MESSAGE
                    
            );
       }
    }//GEN-LAST:event_bModifica1ActionPerformed

    private void bModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificaActionPerformed
        dModifica.setVisible(true);
        dModifica.setLocationRelativeTo(jPanel2);
        
    }//GEN-LAST:event_bModificaActionPerformed

    private void tfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassActionPerformed

    private void bPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPassActionPerformed
       if(tfPass.getText().toString().equals("1012")) {
           mOpen.setEnabled(true);
           mSave.setEnabled(true);
           dPass.setVisible(false);
           label.setVisible(false);
       }
    }//GEN-LAST:event_bPassActionPerformed

    private void mInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInregistrareActionPerformed
        dPass.setVisible(true);
        dPass.setLocationRelativeTo(jPanel2);
    }//GEN-LAST:event_mInregistrareActionPerformed

    private void bCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCautaActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("CNP");
        model.addColumn("Nr. Telefon");
        for (Abonat a : abonati) {
            model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
        }
        tAfisare.setModel(model);
        tSortare.setModel(model);
        tCautare.setModel(model);
        
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        String text = tfCautare.getText();
        tCautare.setRowSorter(sorter);
        if(text.length()==0) {
            sorter.setRowFilter(null);
        }
        else{
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }      
    }//GEN-LAST:event_bCautaActionPerformed

    private void bCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCautareActionPerformed
       dCautare.setVisible(true);
       dCautare.setLocationRelativeTo(jPanel2);
    }//GEN-LAST:event_bCautareActionPerformed

    private void bDa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDa1ActionPerformed

        int i=tAfisare.getSelectedRow();
        abonati.remove(i);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nume");
        model.addColumn("Prenume");
        model.addColumn("CNP");
        model.addColumn("Nr. Telefon");
        for (Abonat a : abonati) {
            model.addRow(new Object[]{a.nume, a.prenume,a.CNP,a.nr.numar});
        }
        tAfisare.setModel(model);
        tSortare.setModel(model);
        tCautare.setModel(model);
        
       
        dSterge.setVisible(false);
    }//GEN-LAST:event_bDa1ActionPerformed
        
    private void bNu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNu1ActionPerformed
        dSterge.setVisible(false);
    }//GEN-LAST:event_bNu1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarteDeTelefon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    
               
                
                SplashScreen splash = new SplashScreen(2000);
                splash.showSplash();
                new CarteDeTelefon().setVisible(true);
            
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdauga;
    private javax.swing.JButton bCauta;
    private javax.swing.JButton bCautare;
    private javax.swing.JButton bDa;
    private javax.swing.JButton bDa1;
    private javax.swing.JButton bIesire;
    private javax.swing.JButton bModifica;
    private javax.swing.JButton bModifica1;
    private javax.swing.JButton bNu;
    private javax.swing.JButton bNu1;
    private javax.swing.JButton bOrdoneaza;
    private javax.swing.JButton bPass;
    private javax.swing.JButton bSortare;
    private javax.swing.JButton bSterge;
    private javax.swing.JButton bValidare;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JDialog dAbout;
    private javax.swing.JDialog dAdauga;
    private javax.swing.JDialog dCautare;
    private javax.swing.JDialog dIesire;
    private javax.swing.JDialog dModifica;
    private javax.swing.JDialog dOrdoneaza;
    private javax.swing.JDialog dPass;
    private javax.swing.JDialog dSterge;
    private javax.swing.JFileChooser fc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lCNP;
    private javax.swing.JLabel lCNP1;
    private javax.swing.JLabel lNrTel;
    private javax.swing.JLabel lNrTel1;
    private javax.swing.JLabel lNume;
    private javax.swing.JLabel lNume1;
    private javax.swing.JLabel lOrdonare;
    private javax.swing.JLabel lPrenume;
    private javax.swing.JLabel lPrenume1;
    private javax.swing.JLabel lSterge;
    private javax.swing.JLabel label;
    private javax.swing.JMenu mAbonati;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mAdauga;
    private javax.swing.JMenuItem mCauta;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenuItem mIesire;
    private javax.swing.JMenuItem mInregistrare;
    private javax.swing.JMenuItem mModifica;
    private javax.swing.JMenuItem mOpen;
    private javax.swing.JMenuItem mSave;
    private javax.swing.JMenuItem mSterge;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton rbCNP;
    private javax.swing.JRadioButton rbNrTel;
    private javax.swing.JRadioButton rbNume;
    private javax.swing.JRadioButton rbPrenume;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tAfisare;
    private javax.swing.JTable tCautare;
    private javax.swing.JTable tSortare;
    private javax.swing.JTextField tfCNP;
    private javax.swing.JTextField tfCNP1;
    private javax.swing.JTextField tfCautare;
    private javax.swing.JTextField tfNrTel;
    private javax.swing.JTextField tfNrTel1;
    private javax.swing.JTextField tfNume;
    private javax.swing.JTextField tfNume1;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfPrenume;
    private javax.swing.JTextField tfPrenume1;
    // End of variables declaration//GEN-END:variables

public void ordoneaza(CriteriuOrdonare c) {
        switch (c) {
            case DUPA_NUME:
                Comparator<Abonat> dupaNume = new Comparator<Abonat>() {

                    public int compare(Abonat a1, Abonat a2) {
                        return a1.getNume().compareTo(a2.getNume());
                    }

                };
                Collections.sort(abonati, dupaNume);
                break;
                
            case DUPA_PRENUME:
             Comparator<Abonat> dupaPrenume = new Comparator<Abonat>() {

                    public int compare(Abonat a1, Abonat a2) {
                    return a1.getPrenume().compareTo(a2.getPrenume());
                    }

                };
                Collections.sort(abonati, dupaPrenume);
                break;
               
            case DUPA_CNP:
                Comparator<Abonat> dupaCNP = new Comparator<Abonat>() {

                    public int compare(Abonat a1, Abonat a2) {
                    return a1.getCNP().compareTo(a2.getCNP());
                    }

                };
                Collections.sort(abonati, dupaCNP);
                break;
                
            case DUPA_NRTEL:
                Comparator<Abonat> dupaNrTel = new Comparator<Abonat>() {

                    public int compare(Abonat a1, Abonat a2) {
                    return a1.getNrTel().compareTo(a2.getNrTel());
                    }

                };
                Collections.sort(abonati, dupaNrTel);
                break;
            

}
}
}
enum CriteriuOrdonare {

    DUPA_NUME,
    DUPA_PRENUME,
    DUPA_CNP,
    DUPA_NRTEL
}