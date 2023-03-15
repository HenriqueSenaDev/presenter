package gov.edu.anm.presenter.view.event;

import gov.edu.anm.presenter.domain.appuser.AppUser;
import gov.edu.anm.presenter.domain.appuser.AppUserTokens;
import gov.edu.anm.presenter.domain.event.Event;
import gov.edu.anm.presenter.domain.utils.SwingUtils;
import gov.edu.anm.presenter.services.PresenterService;

import javax.swing.*;

public class JoinEventFrame extends javax.swing.JFrame {
   private final PresenterService presenterService;
   private final AppUser user;
   private AppUserTokens userTokens;

   public JoinEventFrame(AppUser user, AppUserTokens userTokens, PresenterService presenterService) {
      this.presenterService = presenterService;
      this.user = user;
      this.userTokens = userTokens;

      try {
         initComponents();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   @SuppressWarnings("unchecked")
   private void initComponents() throws Exception {
      java.awt.GridBagConstraints gridBagConstraints;

      eventPanel = new javax.swing.JPanel();
      programBar = new javax.swing.JPanel();
      titleBarSpaceLabel = new javax.swing.JLabel();
      minemizeLabel = new javax.swing.JLabel();
      closeLabel = new javax.swing.JLabel();
      joinEventButton = new javax.swing.JLabel();
      eventCodeTextField = new javax.swing.JTextField();
      eventCodeLabel = new javax.swing.JLabel();
      presenterHeader = new javax.swing.JLabel();
      eventImageLabel = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setMinimumSize(new java.awt.Dimension(474, 252));
      setUndecorated(true);
      setPreferredSize(new java.awt.Dimension(476, 294));

      eventPanel.setBackground(new java.awt.Color(173, 211, 250));
      eventPanel.setPreferredSize(new java.awt.Dimension(476, 269));

      programBar.setBackground(new java.awt.Color(111, 115, 204));
      programBar.setLayout(new java.awt.GridBagLayout());
      gridBagConstraints = new java.awt.GridBagConstraints();
      gridBagConstraints.weightx = 1.0;
      programBar.add(titleBarSpaceLabel, gridBagConstraints);

      minemizeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      minemizeLabel.setForeground(new java.awt.Color(255, 255, 255));
      minemizeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/minimizeIcon.png"))); // NOI18N
      minemizeLabel.setMinimumSize(new java.awt.Dimension(25, 25));
      minemizeLabel.setPreferredSize(new java.awt.Dimension(25, 23));
      minemizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            minimizeWindow();
         }
      });
      gridBagConstraints = new java.awt.GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 0;
      programBar.add(minemizeLabel, gridBagConstraints);

      closeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      closeLabel.setForeground(new java.awt.Color(255, 255, 255));
      closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/closeIcon.png"))); // NOI18N
      closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            closeWindow();
         }
      });
      gridBagConstraints = new java.awt.GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
      programBar.add(closeLabel, gridBagConstraints);

      joinEventButton.setBackground(new java.awt.Color(111, 135, 214));
      joinEventButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
      joinEventButton.setForeground(new java.awt.Color(255, 255, 255));
      joinEventButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      joinEventButton.setText("Entrar");
      joinEventButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      joinEventButton.setMaximumSize(new java.awt.Dimension(35, 20));
      joinEventButton.setMinimumSize(new java.awt.Dimension(35, 18));
      joinEventButton.setOpaque(true);
      joinEventButton.setPreferredSize(new java.awt.Dimension(35, 18));
      joinEventButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            joinEvent();
         }
      });

      eventCodeTextField.setBackground(new java.awt.Color(146, 199, 239));
      eventCodeTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      eventCodeTextField.setForeground(new java.awt.Color(255, 255, 255));
      eventCodeTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

      eventCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      eventCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
      eventCodeLabel.setText("Código do Evento");

      presenterHeader.setFont(SwingUtils.getOleoScriptSwashCapsFont(38f));
      presenterHeader.setForeground(new java.awt.Color(255, 255, 255));
      presenterHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      presenterHeader.setText("Presenter Admin");

      eventImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/event.png"))); // NOI18N

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(eventPanel);
      eventPanel.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(presenterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(9, 9, 9)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(eventCodeLabel)
                     .addComponent(eventCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(joinEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(eventImageLabel)
                  .addGap(49, 49, 49))))
         .addComponent(programBar, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(programBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(presenterHeader)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(32, 32, 32)
                  .addComponent(eventCodeLabel)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(eventCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(50, 50, 50)
                  .addComponent(joinEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(eventImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(26, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(eventPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
      setLocationRelativeTo(null);
   }
   private void minimizeWindow() {
      this.setState(JFrame.ICONIFIED);
   }

   private void closeWindow() {
      System.exit(0);
   }

   private void joinEvent() {
      try {
         String joinCode = eventCodeTextField.getText();
         Event event = presenterService.findEventByJoinCode(joinCode, this.userTokens);

         this.dispose();
      }
      catch (RuntimeException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         SwingUtils.cleanPanelRecordFields(eventPanel);
      }
   }

   private javax.swing.JLabel closeLabel;
   private javax.swing.JLabel eventImageLabel;
   private javax.swing.JPanel eventPanel;
   private javax.swing.JLabel joinEventButton;
   private javax.swing.JLabel minemizeLabel;
   private javax.swing.JLabel presenterHeader;
   private javax.swing.JPanel programBar;
   private javax.swing.JLabel titleBarSpaceLabel;
   private javax.swing.JLabel eventCodeLabel;
   private javax.swing.JTextField eventCodeTextField;
}
