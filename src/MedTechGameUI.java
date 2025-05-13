import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MedTechGameUI extends javax.swing.JFrame {

    public MedTechGameUI(ArrayList<Player> players) {
        this.players = players;
        initComponents();
        nameLabels = new JLabel[] {jLabel1, jLabel2, jLabel3, jLabel4};
        scoreLabels = new JLabel[] {jLabel5, jLabel6, jLabel7, jLabel8};
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(26, 28, 39));
        initButtons();
        setPlayerNames();
    }
    
    Icon iconClear = new ImageIcon(getClass().getResource("medTechImageClear.png"));
    Icon iconMT = new ImageIcon(getClass().getResource("medtechimage.png"));
    int score;
    int highScore = 0;
    private Question[][] questions;
    private ArrayList<Player> players;
    int pressedButtons = 0;
    int turn = 0;
    int rounds = 1;
    JLabel[] nameLabels;
    JLabel[] scoreLabels;
    
    public void initButtons() {
        JButton[][] buttons = new JButton[5][5];
        
        JButton[] oneDButtons = {jButton1, jButton2, jButton3, jButton4, jButton5, 
                             jButton6, jButton7, jButton8, jButton9, jButton10, 
                             jButton11, jButton12, jButton13, jButton14, jButton15,
                             jButton16, jButton17, jButton18, jButton19, jButton20, 
                             jButton21, jButton22, jButton23, jButton24, jButton25
                            };
    int index = 0;
    questions = QuestionGenerator.generateQuestions();

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = oneDButtons[index];
                index++;
                JButton button = buttons[i][j];
                int r = i;
                int c = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new QuestionFrame(MedTechGameUI.this, questions[r][c], players.get(turn), button);
                        setVisible(false);
                    }
                });
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setPlayerNames() {
        for (int i = 0; i < players.size() && i < nameLabels.length; i++) {
            nameLabels[i].setText(players.get(i).name);
        }
        for (int i = 0; i < players.size() && i < nameLabels.length; i++) {
            scoreLabels[i].setText("0");
        }
    }
        
    public void buttonPressed() {
        pressedButtons++;
        if (pressedButtons == 25) {
            endTheGame();
        }
    }
    
    void addScore(int seconds) {
        players.get(turn).score += seconds * 5;
        scoreLabels[turn].setText(String.valueOf(players.get(turn).score));
    }
    
    void changeTurn() {
        nameLabels[turn].setForeground(new Color(110,134,178));
        scoreLabels[turn].setForeground(new Color(110,134,178));
        turn++;
        if (turn == players.size()) {
            turn = 0;
        }
        nameLabels[turn].setForeground(new Color(151,218,226));
        scoreLabels[turn].setForeground(new Color(151,218,226));
    }
    
    public void endTheGame() {
        int result = JOptionPane.showConfirmDialog(null, "All nodes finished! Continue?", "Done!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, iconClear);
        if (result == JOptionPane.YES_OPTION) {
            resetGame();
            rounds++;
        } else {
            players.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
            saveScore(players);
            System.exit(0);
        }
    }

    public void saveScore(ArrayList<Player> players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true))) {
            writer.append(players.get(0).name + "," + players.get(0).score + "," + players.size() + "," + rounds);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
      }
    }
    
    public void resetGame() {
        for (Component c : jPanel1.getComponents()) {
            if (c instanceof JButton) {
                JButton button = (JButton) c;
                button.setEnabled(true);
            }
        }
        questions = QuestionGenerator.generateQuestions();
        pressedButtons = 0;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Med Tech Trivia Quiz!");

        jPanel1.setBackground(new java.awt.Color(75, 64, 96));
        jPanel1.setLayout(new java.awt.GridLayout(5, 5));

        jButton1.setBackground(new java.awt.Color(110, 134, 178));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton1.setFocusable(false);
        jPanel1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(110, 134, 178));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton2.setFocusable(false);
        jPanel1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(110, 134, 178));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton3.setFocusable(false);
        jPanel1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(110, 134, 178));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton4.setFocusable(false);
        jPanel1.add(jButton4);

        jButton5.setBackground(new java.awt.Color(110, 134, 178));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton5.setFocusable(false);
        jPanel1.add(jButton5);

        jButton6.setBackground(new java.awt.Color(110, 134, 178));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton6.setFocusable(false);
        jPanel1.add(jButton6);

        jButton7.setBackground(new java.awt.Color(110, 134, 178));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton7.setFocusable(false);
        jPanel1.add(jButton7);

        jButton8.setBackground(new java.awt.Color(110, 134, 178));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton8.setFocusable(false);
        jPanel1.add(jButton8);

        jButton9.setBackground(new java.awt.Color(110, 134, 178));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton9.setFocusable(false);
        jPanel1.add(jButton9);

        jButton10.setBackground(new java.awt.Color(110, 134, 178));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton10.setFocusable(false);
        jPanel1.add(jButton10);

        jButton11.setBackground(new java.awt.Color(110, 134, 178));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton11.setFocusable(false);
        jPanel1.add(jButton11);

        jButton12.setBackground(new java.awt.Color(110, 134, 178));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton12.setFocusable(false);
        jPanel1.add(jButton12);

        jButton13.setBackground(new java.awt.Color(110, 134, 178));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton13.setFocusable(false);
        jPanel1.add(jButton13);

        jButton14.setBackground(new java.awt.Color(110, 134, 178));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton14.setFocusable(false);
        jPanel1.add(jButton14);

        jButton15.setBackground(new java.awt.Color(110, 134, 178));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton15.setFocusable(false);
        jPanel1.add(jButton15);

        jButton16.setBackground(new java.awt.Color(110, 134, 178));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton16.setFocusable(false);
        jPanel1.add(jButton16);

        jButton17.setBackground(new java.awt.Color(110, 134, 178));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton17.setFocusable(false);
        jPanel1.add(jButton17);

        jButton18.setBackground(new java.awt.Color(110, 134, 178));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton18.setFocusable(false);
        jPanel1.add(jButton18);

        jButton19.setBackground(new java.awt.Color(110, 134, 178));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton19.setFocusable(false);
        jPanel1.add(jButton19);

        jButton20.setBackground(new java.awt.Color(110, 134, 178));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton20.setFocusable(false);
        jPanel1.add(jButton20);

        jButton21.setBackground(new java.awt.Color(110, 134, 178));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton21.setFocusable(false);
        jPanel1.add(jButton21);

        jButton22.setBackground(new java.awt.Color(110, 134, 178));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton22.setFocusable(false);
        jPanel1.add(jButton22);

        jButton23.setBackground(new java.awt.Color(110, 134, 178));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton23.setFocusable(false);
        jPanel1.add(jButton23);

        jButton24.setBackground(new java.awt.Color(110, 134, 178));
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton24.setFocusable(false);
        jPanel1.add(jButton24);

        jButton25.setBackground(new java.awt.Color(110, 134, 178));
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medtechimage.png"))); // NOI18N
        jButton25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton25.setFocusable(false);
        jPanel1.add(jButton25);

        jPanel2.setBackground(new java.awt.Color(75, 64, 96));
        jPanel2.setMinimumSize(new java.awt.Dimension(574, 104));
        jPanel2.setPreferredSize(new java.awt.Dimension(574, 104));

        jButton26.setBackground(new java.awt.Color(110, 134, 178));
        jButton26.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton26.setForeground(new java.awt.Color(26, 28, 39));
        jButton26.setText("Reset!");
        jButton26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 27, 38)));
        jButton26.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(151, 218, 226));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("----------");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(110, 134, 178));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("----------");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(110, 134, 178));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("----------");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(110, 134, 178));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("----------");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(151, 218, 226));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("-");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(110, 134, 178));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("-");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(110, 134, 178));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("-");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(110, 134, 178));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("-");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(120, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, 
                                                   "Are you sure you want to reset?", 
                                                   "Reset?", 
                                                   JOptionPane.YES_NO_OPTION, 
                                                   JOptionPane.WARNING_MESSAGE
                                                   );
        if (result == JOptionPane.YES_OPTION) {
            resetGame();
            rounds = 1;
            nameLabels[turn].setForeground(new Color(110,134,178));
            scoreLabels[turn].setForeground(new Color(110,134,178));
            turn = 0;
            nameLabels[turn].setForeground(new Color(151,218,226));
            scoreLabels[turn].setForeground(new Color(151,218,226));
            JLabel[] labels = {jLabel5, jLabel6, jLabel7, jLabel8};
            for (int i = 0; i < players.size(); i++) {
                players.get(i).score = 0;
                labels[i].setText(String.valueOf(players.get(i).score));
            }
        }
    }//GEN-LAST:event_jButton26ActionPerformed

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
            java.util.logging.Logger.getLogger(MedTechGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedTechGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedTechGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedTechGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


}

