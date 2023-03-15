package gov.edu.anm.presenter.view.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.edu.anm.presenter.domain.appuser.AppRole;
import gov.edu.anm.presenter.domain.appuser.AppUser;
import gov.edu.anm.presenter.domain.appuser.AppUserTokens;
import gov.edu.anm.presenter.domain.auth.AuthResponseDto;
import gov.edu.anm.presenter.domain.exceptions.UnauthorizedException;
import gov.edu.anm.presenter.domain.utils.SwingUtils;
import gov.edu.anm.presenter.services.PresenterService;
import gov.edu.anm.presenter.view.event.JoinEventFrame;

import javax.swing.*;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginFrame extends javax.swing.JFrame {
   private final HttpClient httpClient = HttpClient.newBuilder()
           .connectTimeout(Duration.ofSeconds(3))
           .build();
   private final ObjectMapper mapper = new ObjectMapper();
   private final PresenterService presenterService = new PresenterService(httpClient, mapper);

   public LoginFrame() {
      try {
         initComponents();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
   }

   @SuppressWarnings("unchecked")
   private void initComponents() throws Exception {
      java.awt.GridBagConstraints gridBagConstraints;

      loginPanel = new javax.swing.JPanel();
      programBar = new javax.swing.JPanel();
      titleBarSpaceLabel = new javax.swing.JLabel();
      minemizeLabel = new javax.swing.JLabel();
      closeLabel = new javax.swing.JLabel();
      presenterHeader = new javax.swing.JLabel();
      usernameLabel = new javax.swing.JLabel();
      usernameTextField = new javax.swing.JTextField();
      passwordTextField = new javax.swing.JPasswordField();
      passwordLabel = new javax.swing.JLabel();
      loginButton = new javax.swing.JLabel();
      loginImage = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setUndecorated(true);

      loginPanel.setBackground(new java.awt.Color(173, 211, 250));

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

      presenterHeader.setFont(SwingUtils.getOleoScriptSwashCapsFont(38f));
      presenterHeader.setForeground(new java.awt.Color(255, 255, 255));
      presenterHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      presenterHeader.setText("Presenter Admin");

      usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
      usernameLabel.setText("Usuário");

      usernameTextField.setBackground(new java.awt.Color(146, 199, 239));
      usernameTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      usernameTextField.setForeground(new java.awt.Color(255, 255, 255));
      usernameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

      passwordTextField.setBackground(new java.awt.Color(146, 199, 239));
      passwordTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      passwordTextField.setForeground(new java.awt.Color(255, 255, 255));

      passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
      passwordLabel.setText("Senha");

      loginButton.setBackground(new java.awt.Color(111, 135, 214));
      loginButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
      loginButton.setForeground(new java.awt.Color(255, 255, 255));
      loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      loginButton.setText("Entrar");
      loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      loginButton.setMaximumSize(new java.awt.Dimension(35, 20));
      loginButton.setMinimumSize(new java.awt.Dimension(35, 18));
      loginButton.setOpaque(true);
      loginButton.setPreferredSize(new java.awt.Dimension(35, 18));
      loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            signIn();
         }
      });

      loginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/login.png"))); // NOI18N

      javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
      loginPanel.setLayout(loginPanelLayout);
      loginPanelLayout.setHorizontalGroup(
         loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(programBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(loginPanelLayout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(passwordTextField)
                  .addComponent(passwordLabel)
                  .addComponent(usernameLabel)
                  .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
            .addComponent(loginImage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(45, 45, 45))
         .addGroup(loginPanelLayout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addComponent(presenterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      loginPanelLayout.setVerticalGroup(
         loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(loginPanelLayout.createSequentialGroup()
            .addComponent(programBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(loginPanelLayout.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addComponent(presenterHeader)
                  .addGap(26, 26, 26)
                  .addComponent(usernameLabel)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(passwordLabel)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(46, 46, 46)
                  .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(loginPanelLayout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(loginImage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(47, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

   private Map<String, Object> login() {
      String username = usernameTextField.getText();
      String password = String.copyValueOf(passwordTextField.getPassword());
      AuthResponseDto res = presenterService.authenticate(username, password);

      if (res.getProfile().getRole().equals(AppRole.USER)) {
         throw new UnauthorizedException("Acesso negado.");
      }

      Map<String, Object> loginValues = new HashMap<>();
      loginValues.put("user", res.getProfile());
      loginValues.put("userTokens", new AppUserTokens(res.getAccess_token(), res.getRefresh_token()));
      return loginValues;
   }

   private void signIn() {
      try {
         Map<String, Object> loginValues = login();
         AppUser user = (AppUser) loginValues.get("user");
         AppUserTokens userTokens = (AppUserTokens) loginValues.get("userTokens");

         java.awt.EventQueue.invokeLater(() -> new JoinEventFrame(user, userTokens, presenterService).setVisible(true));
         this.dispose();
      }
      catch (RuntimeException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         SwingUtils.cleanPanelRecordFields(loginPanel);
      }
   }

   public static void main(String[] args) {
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }

      java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
   }

   private javax.swing.JLabel closeLabel;
   private javax.swing.JLabel loginButton;
   private javax.swing.JLabel loginImage;
   private javax.swing.JPanel loginPanel;
   private javax.swing.JLabel minemizeLabel;
   private javax.swing.JLabel passwordLabel;
   private javax.swing.JPasswordField passwordTextField;
   private javax.swing.JLabel presenterHeader;
   private javax.swing.JPanel programBar;
   private javax.swing.JLabel titleBarSpaceLabel;
   private javax.swing.JLabel usernameLabel;
   private javax.swing.JTextField usernameTextField;
}
