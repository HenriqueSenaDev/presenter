package gov.edu.anm.presenter.view.main;

import gov.edu.anm.presenter.domain.appuser.AppUser;
import gov.edu.anm.presenter.domain.appuser.AppUserTokens;
import gov.edu.anm.presenter.domain.auth.RefreshResponseDto;
import gov.edu.anm.presenter.domain.event.Event;
import gov.edu.anm.presenter.domain.team.Team;
import gov.edu.anm.presenter.domain.team.TeamCreateDto;
import gov.edu.anm.presenter.domain.team.TeamUpdateDto;
import gov.edu.anm.presenter.domain.utils.SoundsUtils;
import gov.edu.anm.presenter.domain.utils.SwingUtils;
import gov.edu.anm.presenter.domain.utils.TimerUtils;
import gov.edu.anm.presenter.services.PresenterService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class MainFrame extends javax.swing.JFrame {
    private final PresenterService presenterService;
    private final AppUser user;
    private AppUserTokens userTokens;
    private Event event;

    private Timer countdownTimer;
    private final Timer oscillationTimer = new Timer(550, actionEvt -> countdownOscillation());
    private Timer teamToPresentDrawTimer;
    private Long activeTeamId;

    public MainFrame(AppUser user, AppUserTokens userTokens, Event event, PresenterService presenterService) {
        System.out.println(event);
        this.presenterService = presenterService;
        this.user = user;
        this.userTokens = userTokens;
        this.event = event;

        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private Object requestWithTokensRefreshing(Callable<?> function) throws Exception {
        try {
            return function.call();
        }
        catch (Exception e) {
            if (e.getMessage().contains("JWT expired")) {
                RefreshResponseDto refreshRes = this.presenterService.refreshToken(this.userTokens.getRefresh_token());
                this.userTokens = new AppUserTokens(refreshRes.getAccess_token(), refreshRes.getRefresh_token());

                return function.call();
            }
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        programBar = new javax.swing.JPanel();
        titleBarSpaceLabel = new javax.swing.JLabel();
        minemizeLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        titleBar = new javax.swing.JPanel();
        menuIcon = new javax.swing.JLabel();
        presenterLabel = new javax.swing.JLabel();
        mainbarSpaceLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        abas = new javax.swing.JTabbedPane();
        abaEquipes = new javax.swing.JPanel();
        equipeCadastro = new javax.swing.JPanel();
        equipeNomeLabel = new javax.swing.JLabel();
        equipeNomeTextField = new javax.swing.JTextField();
        equipeProjetoLabel = new javax.swing.JLabel();
        equipeProjetoTextField = new javax.swing.JTextField();
        equipeTurmaLabel = new javax.swing.JLabel();
        equipeTurmaComboBox = new javax.swing.JComboBox<>();
        equipeApresentouLabel = new javax.swing.JLabel();
        equipeApresentouComboBox = new javax.swing.JComboBox<>();
        equipeNovaBotao = new javax.swing.JLabel();
        equipeSalvarBotao = new javax.swing.JLabel();
        equipeEditarBotao = new javax.swing.JLabel();
        equipeExcluirBotao = new javax.swing.JLabel();
        equipeAlunoLabel = new javax.swing.JLabel();
        equipeAlunoTextField = new javax.swing.JTextField();
        equipeAddAlunoBotao = new javax.swing.JLabel();
        equipeRemoveAlunoBotao = new javax.swing.JLabel();
        equipeAlunosDaEquipeContentPanel = new javax.swing.JScrollPane();
        equipeAlunosDaEquipeLista = new javax.swing.JList<>();
        equipeDivideBar = new javax.swing.JPanel();
        equipePesquisaPanel = new javax.swing.JPanel();
        equipePesquisaBar = new javax.swing.JPanel();
        equipePesquisaLabel = new javax.swing.JLabel();
        equipePesquisaTextField = new javax.swing.JTextField();
        equipePorLabel = new javax.swing.JLabel();
        equipePorComboBox = new javax.swing.JComboBox<>();
        equipeTabelaPanel = new javax.swing.JPanel();
        equipeTabelaContent = new javax.swing.JScrollPane();
        equipeTabela = new javax.swing.JTable();
        abaTemporizador = new javax.swing.JPanel();
        tempoAreaPanel = new javax.swing.JPanel();
        whiteCircleLabel = new javax.swing.JLabel();
        redCircleLabel = new javax.swing.JLabel();
        tempoNumbers = new javax.swing.JLabel();
        tempoDivideBar = new javax.swing.JPanel();
        tempoConfigPanel = new javax.swing.JPanel();
        tempoDuracaoPanel = new javax.swing.JPanel();
        tempoTempoLabel = new javax.swing.JLabel();
        tempoDuracaoComboBox = new javax.swing.JComboBox<>();
        tempoCustomLabel = new javax.swing.JLabel();
        tempoCustomTextField = new javax.swing.JFormattedTextField();
        tempoMinutesLabel = new javax.swing.JLabel();
        tempoActionsPanel = new javax.swing.JPanel();
        tempoPlayLabel = new javax.swing.JLabel();
        tempoDeleteLabel = new javax.swing.JLabel();
        abaSorteador = new javax.swing.JPanel();
        sorteadorEquipePanel = new javax.swing.JPanel();
        sorteadorEquipeLabel = new javax.swing.JLabel();
        sorteioDivideBar = new javax.swing.JPanel();
        sorteadorSortearPanel = new javax.swing.JPanel();
        sorteadorSortearBotao = new javax.swing.JLabel();
        sorteadorEquipesRestandoLabel = new javax.swing.JLabel();
        sorteadorApresentouLabel = new javax.swing.JLabel();
        sorteadorNaoAprensentouLabel = new javax.swing.JLabel();
        abaRanking = new javax.swing.JPanel();
        rankingHeadPanel = new javax.swing.JPanel();
        relatorioAtrasoLabel = new javax.swing.JLabel();
        rankingTablePanel = new javax.swing.JPanel();
        rankingTabelaContent = new javax.swing.JScrollPane();
        rankingTabela = new javax.swing.JTable();
        menuBar = new javax.swing.JPanel();
        equipesActivePanel = new javax.swing.JPanel();
        equipesMenuLabel = new javax.swing.JLabel();
        temporizadorActivePanel = new javax.swing.JPanel();
        tempMenuLabel = new javax.swing.JLabel();
        sorteadorMenuActivePanel = new javax.swing.JPanel();
        sorteadorMenuLabel = new javax.swing.JLabel();
        rankingMenuActivePanel = new javax.swing.JPanel();
        rankingMenuLabel = new javax.swing.JLabel();
        inMenuBarSpaceLabel = new javax.swing.JLabel();
        menuRightPanel = new javax.swing.JPanel();
        space = new javax.swing.JLabel();
        menuFundoLargo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated();
            }
        });
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        mainPanel.setBackground(new java.awt.Color(120, 133, 231));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        programBar.setBackground(new java.awt.Color(111, 115, 204));
        programBar.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        programBar.setPreferredSize(new java.awt.Dimension(633, 25));
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        mainPanel.add(programBar, gridBagConstraints);

        titleBar.setBackground(new java.awt.Color(146, 199, 239));
        titleBar.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        titleBar.setMinimumSize(new java.awt.Dimension(240, 50));
        titleBar.setPreferredSize(new java.awt.Dimension(240, 50));
        titleBar.setLayout(new java.awt.GridBagLayout());

        menuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/menuIcon.png"))); // NOI18N
        menuIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleMenu();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 5, 12);
        titleBar.add(menuIcon, gridBagConstraints);

        presenterLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        presenterLabel.setForeground(new java.awt.Color(255, 255, 255));
        presenterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        presenterLabel.setText("Presenter");
        titleBar.add(presenterLabel, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        titleBar.add(mainbarSpaceLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(titleBar, gridBagConstraints);

        contentPanel.setBackground(new java.awt.Color(120, 128, 175));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abas.setMinimumSize(new java.awt.Dimension(900, 575));
        abas.setPreferredSize(new java.awt.Dimension(1400, 730));

        abaEquipes.setBackground(new java.awt.Color(173, 211, 250));
        abaEquipes.setLayout(new java.awt.GridBagLayout());

        equipeCadastro.setBackground(new java.awt.Color(173, 211, 250));
        equipeCadastro.setForeground(new java.awt.Color(146, 199, 239));
        equipeCadastro.setMaximumSize(new java.awt.Dimension(2147483647, 600));
        equipeCadastro.setMinimumSize(new java.awt.Dimension(698, 300));
        equipeCadastro.setPreferredSize(new java.awt.Dimension(600, 300));
        equipeCadastro.setLayout(new java.awt.GridBagLayout());

        equipeNomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipeNomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipeNomeLabel.setText("Equipe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        equipeCadastro.add(equipeNomeLabel, gridBagConstraints);

        equipeNomeTextField.setBackground(new java.awt.Color(146, 199, 239));
        equipeNomeTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeNomeTextField.setForeground(new java.awt.Color(255, 255, 255));
        equipeNomeTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        equipeNomeTextField.setMinimumSize(new java.awt.Dimension(350, 30));
        equipeNomeTextField.setPreferredSize(new java.awt.Dimension(375, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 80, 25, 0);
        equipeCadastro.add(equipeNomeTextField, gridBagConstraints);

        equipeProjetoLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipeProjetoLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipeProjetoLabel.setText("Projeto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        equipeCadastro.add(equipeProjetoLabel, gridBagConstraints);

        equipeProjetoTextField.setBackground(new java.awt.Color(146, 199, 239));
        equipeProjetoTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeProjetoTextField.setForeground(new java.awt.Color(255, 255, 255));
        equipeProjetoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        equipeProjetoTextField.setMinimumSize(new java.awt.Dimension(350, 30));
        equipeProjetoTextField.setPreferredSize(new java.awt.Dimension(375, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 80, 25, 0);
        equipeCadastro.add(equipeProjetoTextField, gridBagConstraints);

        equipeTurmaLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipeTurmaLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipeTurmaLabel.setText("Turma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        equipeCadastro.add(equipeTurmaLabel, gridBagConstraints);

        equipeTurmaComboBox.setBackground(new java.awt.Color(51, 51, 255));
        equipeTurmaComboBox.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        equipeTurmaComboBox.setForeground(new java.awt.Color(255, 255, 255));
        equipeTurmaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º Administração", "1º Enfermagem", "1º Informática", "2º Administração", "2º Enfermagem", "2º Informática", "3º Administração", "3º Enfermagem", "3º Informática" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 75, 30, 0);
        equipeCadastro.add(equipeTurmaComboBox, gridBagConstraints);

        equipeApresentouLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipeApresentouLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipeApresentouLabel.setText("Apresentou:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 80);
        equipeCadastro.add(equipeApresentouLabel, gridBagConstraints);

        equipeApresentouComboBox.setBackground(new java.awt.Color(51, 51, 255));
        equipeApresentouComboBox.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        equipeApresentouComboBox.setForeground(new java.awt.Color(255, 255, 255));
        equipeApresentouComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 30, 0);
        equipeCadastro.add(equipeApresentouComboBox, gridBagConstraints);

        equipeNovaBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeNovaBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeNovaBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeNovaBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeNovaBotao.setText("Limpar");
        equipeNovaBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeNovaBotao.setMaximumSize(new java.awt.Dimension(70, 32));
        equipeNovaBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeNovaBotao.setOpaque(true);
        equipeNovaBotao.setPreferredSize(new java.awt.Dimension(80, 32));
        equipeNovaBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanTeamRecordFields();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 0);
        equipeCadastro.add(equipeNovaBotao, gridBagConstraints);

        equipeSalvarBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeSalvarBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeSalvarBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeSalvarBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeSalvarBotao.setText("Salvar");
        equipeSalvarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeSalvarBotao.setMaximumSize(new java.awt.Dimension(70, 32));
        equipeSalvarBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeSalvarBotao.setOpaque(true);
        equipeSalvarBotao.setPreferredSize(new java.awt.Dimension(70, 32));
        equipeSalvarBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createTeamInEvent();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 145, 0, 0);
        equipeCadastro.add(equipeSalvarBotao, gridBagConstraints);

        equipeEditarBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeEditarBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeEditarBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeEditarBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeEditarBotao.setText("Editar");
        equipeEditarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeEditarBotao.setMaximumSize(new java.awt.Dimension(70, 32));
        equipeEditarBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeEditarBotao.setOpaque(true);
        equipeEditarBotao.setPreferredSize(new java.awt.Dimension(70, 32));
        equipeEditarBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTeam();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 135);
        equipeCadastro.add(equipeEditarBotao, gridBagConstraints);

        equipeExcluirBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeExcluirBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeExcluirBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeExcluirBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeExcluirBotao.setText("Excluir");
        equipeExcluirBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeExcluirBotao.setMaximumSize(new java.awt.Dimension(70, 32));
        equipeExcluirBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeExcluirBotao.setOpaque(true);
        equipeExcluirBotao.setPreferredSize(new java.awt.Dimension(75, 32));
        equipeExcluirBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTeam();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        equipeCadastro.add(equipeExcluirBotao, gridBagConstraints);

        equipeAlunoLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipeAlunoLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipeAlunoLabel.setText("Aluno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 25, 0);
        equipeCadastro.add(equipeAlunoLabel, gridBagConstraints);

        equipeAlunoTextField.setBackground(new java.awt.Color(146, 199, 239));
        equipeAlunoTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeAlunoTextField.setForeground(new java.awt.Color(255, 255, 255));
        equipeAlunoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        equipeAlunoTextField.setMinimumSize(new java.awt.Dimension(350, 30));
        equipeAlunoTextField.setPreferredSize(new java.awt.Dimension(340, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 25, 0);
        equipeCadastro.add(equipeAlunoTextField, gridBagConstraints);

        equipeAddAlunoBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeAddAlunoBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeAddAlunoBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeAddAlunoBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeAddAlunoBotao.setText("Adicionar");
        equipeAddAlunoBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeAddAlunoBotao.setMaximumSize(new java.awt.Dimension(95, 25));
        equipeAddAlunoBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeAddAlunoBotao.setOpaque(true);
        equipeAddAlunoBotao.setPreferredSize(new java.awt.Dimension(95, 32));
        equipeAddAlunoBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMemberInTeam();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 120);
        equipeCadastro.add(equipeAddAlunoBotao, gridBagConstraints);

        equipeRemoveAlunoBotao.setBackground(new java.awt.Color(111, 135, 214));
        equipeRemoveAlunoBotao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeRemoveAlunoBotao.setForeground(new java.awt.Color(255, 255, 255));
        equipeRemoveAlunoBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipeRemoveAlunoBotao.setText("Remover");
        equipeRemoveAlunoBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipeRemoveAlunoBotao.setMaximumSize(new java.awt.Dimension(95, 25));
        equipeRemoveAlunoBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        equipeRemoveAlunoBotao.setOpaque(true);
        equipeRemoveAlunoBotao.setPreferredSize(new java.awt.Dimension(95, 32));
        equipeRemoveAlunoBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMemberFromTeam();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 120, 0, 0);
        equipeCadastro.add(equipeRemoveAlunoBotao, gridBagConstraints);

        equipeAlunosDaEquipeContentPanel.setMinimumSize(new java.awt.Dimension(470, 160));
        equipeAlunosDaEquipeContentPanel.setPreferredSize(new java.awt.Dimension(470, 125));

        equipeAlunosDaEquipeLista.setBackground(new java.awt.Color(146, 199, 239));
        equipeAlunosDaEquipeLista.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeAlunosDaEquipeLista.setForeground(new java.awt.Color(255, 255, 255));
        equipeAlunosDaEquipeLista.setMinimumSize(new java.awt.Dimension(65, 135));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.setSize(0);
        equipeAlunosDaEquipeLista.setModel(listModel);
        equipeAlunosDaEquipeContentPanel.setViewportView(equipeAlunosDaEquipeLista);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(45, 30, 0, 0);
        equipeCadastro.add(equipeAlunosDaEquipeContentPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        abaEquipes.add(equipeCadastro, gridBagConstraints);

        equipeDivideBar.setBackground(new java.awt.Color(255, 255, 255));
        equipeDivideBar.setMinimumSize(new java.awt.Dimension(10, 5));
        equipeDivideBar.setPreferredSize(new java.awt.Dimension(10, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        abaEquipes.add(equipeDivideBar, gridBagConstraints);

        equipePesquisaPanel.setBackground(new java.awt.Color(173, 211, 250));
        equipePesquisaPanel.setLayout(new java.awt.GridBagLayout());

        equipePesquisaBar.setBackground(new java.awt.Color(173, 211, 250));
        equipePesquisaBar.setMinimumSize(new java.awt.Dimension(615, 90));
        equipePesquisaBar.setPreferredSize(new java.awt.Dimension(615, 90));
        equipePesquisaBar.setLayout(new java.awt.GridBagLayout());

        equipePesquisaLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipePesquisaLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipePesquisaLabel.setText("Pesquisa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        equipePesquisaBar.add(equipePesquisaLabel, gridBagConstraints);

        equipePesquisaTextField.setBackground(new java.awt.Color(146, 199, 239));
        equipePesquisaTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipePesquisaTextField.setForeground(new java.awt.Color(255, 255, 255));
        equipePesquisaTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        equipePesquisaTextField.setMinimumSize(new java.awt.Dimension(350, 35));
        equipePesquisaTextField.setPreferredSize(new java.awt.Dimension(350, 35));
        equipePesquisaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teamsSearchFilter();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 95, 10, 20);
        equipePesquisaBar.add(equipePesquisaTextField, gridBagConstraints);

        equipePorLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        equipePorLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipePorLabel.setText("Por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 470, 10, 0);
        equipePesquisaBar.add(equipePorLabel, gridBagConstraints);

        equipePorComboBox.setBackground(new java.awt.Color(51, 51, 255));
        equipePorComboBox.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        equipePorComboBox.setForeground(new java.awt.Color(255, 255, 255));
        equipePorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Projeto", "Aluno" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 515, 10, 0);
        equipePesquisaBar.add(equipePorComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        equipePesquisaPanel.add(equipePesquisaBar, gridBagConstraints);

        equipeTabelaPanel.setBackground(new java.awt.Color(173, 211, 250));
        equipeTabelaPanel.setMinimumSize(new java.awt.Dimension(1100, 402));
        equipeTabelaPanel.setPreferredSize(new java.awt.Dimension(1100, 402));
        equipeTabelaPanel.setLayout(new java.awt.GridBagLayout());

        equipeTabelaContent.setForeground(new java.awt.Color(255, 255, 255));
        equipeTabelaContent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeTabelaContent.setMinimumSize(new java.awt.Dimension(900, 402));
        equipeTabelaContent.setPreferredSize(new java.awt.Dimension(900, 402));

        equipeTabela.setBackground(new java.awt.Color(146, 199, 239));
        equipeTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipeTabela.setForeground(new java.awt.Color(255, 255, 255));
        equipeTabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Id", "Nome", "Projeto", "Turma", "Apresentou", "Alunos"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        equipeTabela.setToolTipText("\n");
        equipeTabela.setGridColor(new java.awt.Color(146, 199, 239));
        equipeTabela.setMinimumSize(new java.awt.Dimension(510, 300));
        equipeTabela.setPreferredSize(new java.awt.Dimension(630, 300));
        equipeTabela.setRowHeight(25);
        equipeTabela.setSelectionBackground(new java.awt.Color(173, 211, 250));
        equipeTabela.setShowGrid(false);
        equipeTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamsTableRowClicked();
            }
        });
        equipeTabelaContent.setViewportView(equipeTabela);
        if (equipeTabela.getColumnModel().getColumnCount() > 0) {
            equipeTabela.getColumnModel().getColumn(0).setPreferredWidth(40);
            equipeTabela.getColumnModel().getColumn(0).setMaxWidth(40);
            equipeTabela.getColumnModel().getColumn(3).setMinWidth(170);
            equipeTabela.getColumnModel().getColumn(3).setMaxWidth(170);
            equipeTabela.getColumnModel().getColumn(4).setMinWidth(80);
            equipeTabela.getColumnModel().getColumn(4).setPreferredWidth(80);
            equipeTabela.getColumnModel().getColumn(4).setMaxWidth(80);
            equipeTabela.getColumnModel().getColumn(5).setMinWidth(280);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        equipeTabelaPanel.add(equipeTabelaContent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        equipePesquisaPanel.add(equipeTabelaPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        abaEquipes.add(equipePesquisaPanel, gridBagConstraints);

        abas.addTab("tab1", abaEquipes);

        abaTemporizador.setBackground(new java.awt.Color(173, 211, 250));
        abaTemporizador.setLayout(new java.awt.GridBagLayout());

        tempoAreaPanel.setBackground(new java.awt.Color(173, 211, 250));
        tempoAreaPanel.setMaximumSize(new java.awt.Dimension(2147483647, 325));
        tempoAreaPanel.setMinimumSize(new java.awt.Dimension(785, 325));
        tempoAreaPanel.setPreferredSize(new java.awt.Dimension(785, 200));
        tempoAreaPanel.setLayout(new java.awt.GridBagLayout());

        whiteCircleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/whiteCircle.png"))); // NOI18N
        tempoAreaPanel.add(whiteCircleLabel, new java.awt.GridBagConstraints());

        redCircleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/redCircle.png"))); // NOI18N
        redCircleLabel.setVisible(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 0, 0);
        tempoAreaPanel.add(redCircleLabel, gridBagConstraints);

        tempoNumbers.setFont(new java.awt.Font("Segoe UI", 1, 85)); // NOI18N
        tempoNumbers.setForeground(new java.awt.Color(255, 255, 255));
        tempoNumbers.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tempoAreaPanel.add(tempoNumbers, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        abaTemporizador.add(tempoAreaPanel, gridBagConstraints);

        tempoDivideBar.setBackground(new java.awt.Color(255, 255, 255));
        tempoDivideBar.setMinimumSize(new java.awt.Dimension(10, 5));
        tempoDivideBar.setPreferredSize(new java.awt.Dimension(10, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        abaTemporizador.add(tempoDivideBar, gridBagConstraints);

        tempoConfigPanel.setBackground(new java.awt.Color(173, 211, 250));
        tempoConfigPanel.setMaximumSize(new java.awt.Dimension(2147483647, 180));
        tempoConfigPanel.setMinimumSize(new java.awt.Dimension(615, 180));
        tempoConfigPanel.setPreferredSize(new java.awt.Dimension(615, 200));
        tempoConfigPanel.setLayout(new java.awt.GridBagLayout());

        tempoDuracaoPanel.setBackground(new java.awt.Color(173, 211, 250));
        tempoDuracaoPanel.setMinimumSize(new java.awt.Dimension(615, 90));
        tempoDuracaoPanel.setPreferredSize(new java.awt.Dimension(615, 80));
        tempoDuracaoPanel.setLayout(new java.awt.GridBagLayout());

        tempoTempoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tempoTempoLabel.setForeground(new java.awt.Color(255, 255, 255));
        tempoTempoLabel.setText("Tempo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        tempoDuracaoPanel.add(tempoTempoLabel, gridBagConstraints);

        tempoDuracaoComboBox.setBackground(new java.awt.Color(51, 51, 255));
        tempoDuracaoComboBox.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tempoDuracaoComboBox.setForeground(new java.awt.Color(255, 255, 255));
        tempoDuracaoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 minutos", "10 minutos", "15 minutos", "20 minutos", "Customizado" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        tempoDuracaoPanel.add(tempoDuracaoComboBox, gridBagConstraints);

        tempoCustomLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tempoCustomLabel.setForeground(new java.awt.Color(255, 255, 255));
        tempoCustomLabel.setText("Customizado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        tempoDuracaoPanel.add(tempoCustomLabel, gridBagConstraints);

        tempoCustomTextField.setBackground(new java.awt.Color(146, 199, 239));
        tempoCustomTextField.setForeground(new java.awt.Color(255, 255, 255));
        try {
            tempoCustomTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tempoCustomTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tempoCustomTextField.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tempoCustomTextField.setPreferredSize(new java.awt.Dimension(85, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        tempoDuracaoPanel.add(tempoCustomTextField, gridBagConstraints);

        tempoMinutesLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tempoMinutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        tempoMinutesLabel.setText("minutos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        tempoDuracaoPanel.add(tempoMinutesLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        tempoConfigPanel.add(tempoDuracaoPanel, gridBagConstraints);

        tempoActionsPanel.setBackground(new java.awt.Color(173, 211, 250));
        tempoActionsPanel.setPreferredSize(new java.awt.Dimension(10, 90));
        tempoActionsPanel.setLayout(new java.awt.GridBagLayout());

        tempoPlayLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/playIcon.png"))); // NOI18N
        tempoPlayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playCountdownTimer(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        tempoActionsPanel.add(tempoPlayLabel, gridBagConstraints);

        tempoDeleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/deleteIcon.png"))); // NOI18N
        tempoDeleteLabel.setVisible(false);
        tempoDeleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelCountdown(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        tempoActionsPanel.add(tempoDeleteLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        tempoConfigPanel.add(tempoActionsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        abaTemporizador.add(tempoConfigPanel, gridBagConstraints);

        abas.addTab("tab2", abaTemporizador);

        abaSorteador.setBackground(new java.awt.Color(173, 211, 250));
        abaSorteador.setLayout(new java.awt.GridBagLayout());

        sorteadorEquipePanel.setBackground(new java.awt.Color(173, 211, 250));
        sorteadorEquipePanel.setLayout(new java.awt.GridBagLayout());

        sorteadorEquipeLabel.setFont(new java.awt.Font("Segoe UI", 1, 64)); // NOI18N
        sorteadorEquipeLabel.setForeground(new java.awt.Color(255, 255, 255));
        sorteadorEquipeLabel.setText("Equipe Selecionada");
        sorteadorEquipePanel.add(sorteadorEquipeLabel, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        abaSorteador.add(sorteadorEquipePanel, gridBagConstraints);

        sorteioDivideBar.setBackground(new java.awt.Color(255, 255, 255));
        sorteioDivideBar.setMinimumSize(new java.awt.Dimension(10, 5));
        sorteioDivideBar.setPreferredSize(new java.awt.Dimension(10, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        abaSorteador.add(sorteioDivideBar, gridBagConstraints);

        sorteadorSortearPanel.setBackground(new java.awt.Color(173, 211, 250));
        sorteadorSortearPanel.setPreferredSize(new java.awt.Dimension(547, 250));
        sorteadorSortearPanel.setLayout(new java.awt.GridBagLayout());

        sorteadorSortearBotao.setBackground(new java.awt.Color(111, 135, 214));
        sorteadorSortearBotao.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        sorteadorSortearBotao.setForeground(new java.awt.Color(255, 255, 255));
        sorteadorSortearBotao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sorteadorSortearBotao.setText("Sortear equipes restantes");
        sorteadorSortearBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sorteadorSortearBotao.setMaximumSize(new java.awt.Dimension(70, 32));
        sorteadorSortearBotao.setMinimumSize(new java.awt.Dimension(70, 32));
        sorteadorSortearBotao.setOpaque(true);
        sorteadorSortearBotao.setPreferredSize(new java.awt.Dimension(340, 45));
        sorteadorSortearBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawTeamToPresent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(45, 0, 25, 0);
        sorteadorSortearPanel.add(sorteadorSortearBotao, gridBagConstraints);

        sorteadorEquipesRestandoLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        sorteadorEquipesRestandoLabel.setForeground(new java.awt.Color(255, 255, 255));
        sorteadorEquipesRestandoLabel.setText("Nenhuma equipe restando");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        sorteadorSortearPanel.add(sorteadorEquipesRestandoLabel, gridBagConstraints);

        sorteadorApresentouLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/doneIcon.png"))); // NOI18N
        sorteadorApresentouLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmPresentation(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 130);
        sorteadorSortearPanel.add(sorteadorApresentouLabel, gridBagConstraints);

        sorteadorNaoAprensentouLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/closeBigIcon.png"))); // NOI18N
        sorteadorNaoAprensentouLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelPresentation(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 130, 0, 0);
        sorteadorSortearPanel.add(sorteadorNaoAprensentouLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        abaSorteador.add(sorteadorSortearPanel, gridBagConstraints);

        abas.addTab("tab4", abaSorteador);

        abaRanking.setBackground(new java.awt.Color(173, 211, 250));
        abaRanking.setLayout(new java.awt.GridBagLayout());

        rankingHeadPanel.setBackground(new java.awt.Color(173, 211, 250));
        rankingHeadPanel.setMinimumSize(new java.awt.Dimension(10, 70));
        rankingHeadPanel.setPreferredSize(new java.awt.Dimension(10, 70));
        rankingHeadPanel.setLayout(new java.awt.GridBagLayout());

        relatorioAtrasoLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        relatorioAtrasoLabel.setForeground(new java.awt.Color(255, 255, 255));
        relatorioAtrasoLabel.setText("Ranking da Competição");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 30, 0);
        rankingHeadPanel.add(relatorioAtrasoLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        abaRanking.add(rankingHeadPanel, gridBagConstraints);

        rankingTablePanel.setBackground(new java.awt.Color(173, 211, 250));
        rankingTablePanel.setLayout(new java.awt.GridBagLayout());

        rankingTabelaContent.setMinimumSize(new java.awt.Dimension(800, 500));
        rankingTabelaContent.setPreferredSize(new java.awt.Dimension(1000, 500));

        rankingTabela.setBackground(new java.awt.Color(146, 199, 239));
        rankingTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rankingTabela.setForeground(new java.awt.Color(255, 255, 255));
        rankingTabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Equipe", "Projeto", "Turma", "Avaliações", "Média Geral"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rankingTabela.setGridColor(new java.awt.Color(146, 199, 239));
        rankingTabela.setRowHeight(25);
        rankingTabelaContent.setViewportView(rankingTabela);
        if (rankingTabela.getColumnModel().getColumnCount() > 0) {
            rankingTabela.getColumnModel().getColumn(3).setMinWidth(80);
            rankingTabela.getColumnModel().getColumn(3).setMaxWidth(80);
            rankingTabela.getColumnModel().getColumn(4).setMinWidth(100);
            rankingTabela.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 20, 50);
        rankingTablePanel.add(rankingTabelaContent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        abaRanking.add(rankingTablePanel, gridBagConstraints);

        abas.addTab("tab4", abaRanking);

        contentPanel.add(abas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -39, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(contentPanel, gridBagConstraints);

        menuBar.setBackground(new java.awt.Color(173, 211, 250));
        menuBar.setAlignmentX(0.0F);
        menuBar.setAlignmentY(0.0F);
        menuBar.setMaximumSize(new java.awt.Dimension(260, 32767));
        menuBar.setMinimumSize(new java.awt.Dimension(250, 536));
        menuBar.setPreferredSize(new java.awt.Dimension(260, 50));
        menuBar.setLayout(new java.awt.GridBagLayout());
        menuBar.setVisible(false);
        menuBar.setEnabled(false);

        equipesActivePanel.setBackground(new java.awt.Color(173, 211, 250));
        equipesActivePanel.setMinimumSize(new java.awt.Dimension(5, 35));
        equipesActivePanel.setPreferredSize(new java.awt.Dimension(5, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(equipesActivePanel, gridBagConstraints);

        equipesMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        equipesMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipesMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipesMenuLabel.setText("Cadastro de Equipes");
        equipesMenuLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipesMenuLabel.setPreferredSize(new java.awt.Dimension(183, 35));
        equipesMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abas.setSelectedIndex(0);
                closeMenu();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundHover(equipesActivePanel);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundOut(equipesActivePanel);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 15, 0);
        menuBar.add(equipesMenuLabel, gridBagConstraints);

        temporizadorActivePanel.setBackground(new java.awt.Color(173, 211, 250));
        temporizadorActivePanel.setMinimumSize(new java.awt.Dimension(5, 35));
        temporizadorActivePanel.setPreferredSize(new java.awt.Dimension(5, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(temporizadorActivePanel, gridBagConstraints);

        tempMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        tempMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        tempMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempMenuLabel.setText("Temporizador");
        tempMenuLabel.setToolTipText("");
        tempMenuLabel.setPreferredSize(new java.awt.Dimension(174, 35));
        tempMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abas.setSelectedIndex(1);
                closeMenu();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundHover(temporizadorActivePanel);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundOut(temporizadorActivePanel);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(tempMenuLabel, gridBagConstraints);

        sorteadorMenuActivePanel.setBackground(new java.awt.Color(173, 211, 250));
        sorteadorMenuActivePanel.setMinimumSize(new java.awt.Dimension(5, 35));
        sorteadorMenuActivePanel.setPreferredSize(new java.awt.Dimension(5, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(sorteadorMenuActivePanel, gridBagConstraints);

        sorteadorMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        sorteadorMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        sorteadorMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sorteadorMenuLabel.setText("Sorteador");
        sorteadorMenuLabel.setPreferredSize(new java.awt.Dimension(113, 35));
        sorteadorMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abas.setSelectedIndex(2);
                closeMenu();
                setTeamsDrawLabel();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundHover(sorteadorMenuActivePanel);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundOut(sorteadorMenuActivePanel);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(sorteadorMenuLabel, gridBagConstraints);

        rankingMenuActivePanel.setBackground(new java.awt.Color(173, 211, 250));
        rankingMenuActivePanel.setMinimumSize(new java.awt.Dimension(5, 35));
        rankingMenuActivePanel.setPreferredSize(new java.awt.Dimension(5, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(rankingMenuActivePanel, gridBagConstraints);

        rankingMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        rankingMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        rankingMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rankingMenuLabel.setText("Ranking");
        rankingMenuLabel.setPreferredSize(new java.awt.Dimension(113, 35));
        rankingMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abas.setSelectedIndex(3);
                closeMenu();
                populateRankingTable();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundHover(rankingMenuActivePanel);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLabelBackgroundOut(rankingMenuActivePanel);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        menuBar.add(rankingMenuLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        menuBar.add(inMenuBarSpaceLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(menuBar, gridBagConstraints);

        menuRightPanel.setBackground(new java.awt.Color(120, 133, 231));
        menuRightPanel.setLayout(new java.awt.GridBagLayout());
        menuRightPanel.setVisible(false);
        menuRightPanel.setEnabled(false);

        space.setMinimumSize(new java.awt.Dimension(250, 0));
        space.setPreferredSize(new java.awt.Dimension(250, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        menuRightPanel.add(space, gridBagConstraints);

        menuFundoLargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gov/edu/anm/presenter/assets/images/fundoMenuLargo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        menuRightPanel.add(menuFundoLargo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(menuRightPanel, gridBagConstraints);

        getContentPane().add(mainPanel);

        setSize(new java.awt.Dimension(898, 589));
        setLocationRelativeTo(null);
    }

    // Program bar and header event buttons
    private void minimizeWindow() {
        this.setState(JFrame.ICONIFIED);
    }

    private void closeWindow() {
        System.exit(0);
    }

    private void toggleMenu() {
        if (contentPanel.isVisible()) {
            contentPanel.setVisible(false);
            contentPanel.setEnabled(false);
            menuBar.setVisible(true);
            menuBar.setEnabled(true);
            menuRightPanel.setVisible(true);
            menuRightPanel.setEnabled(true);
        }
        else {
            contentPanel.setVisible(true);
            contentPanel.setEnabled(true);
            menuBar.setVisible(false);
            menuBar.setEnabled(false);
            menuRightPanel.setVisible(false);
            menuRightPanel.setEnabled(false);
        }
    }

    // Menu mouse hover events
    private void menuLabelBackgroundHover(JPanel panel){
        panel.setBackground(new Color(255, 255, 255));
    }

    private void menuLabelBackgroundOut(JPanel panel){
        panel.setBackground(new Color(173, 211, 250));
    }

    // Menu items clicked events
    private void closeMenu(){
        contentPanel.setVisible(true);
        contentPanel.setEnabled(true);
        menuBar.setVisible(false);
        menuBar.setEnabled(false);
    }

    private void setTeamsDrawLabel() {
        final String label;
        final int n = this.event.getTeamsToPresent().size();

        if (n == 0) {
            label = "Nenhuma equipe restando";
        }
        else {
            label = (n >= 10 ? String.valueOf(n) : "0" + n)
                    + " equipe" + (n == 1 ? "" : "s") + " restando";
        }
        sorteadorEquipesRestandoLabel.setText(label);
    }

    private void populateRankingTable() {
        List<Team> teams = new ArrayList<>(this.event.getTeams());
        DefaultTableModel dados = (DefaultTableModel) rankingTabela.getModel();
        dados.setNumRows(0);

        teams.sort((Team t1, Team t2) -> t2.getAverage().compareTo(t1.getAverage()));

        for (Team team : teams) {
            dados.addRow(new Object[]{
                    team.getName(),
                    team.getProject(),
                    team.getClassroom(),
                    team.getAvaliationsQuantity(),
                    String.format("%.1f", team.getAverage())
            });
        }

        while (dados.getRowCount() < 19) {
            dados.addRow(new Object[]{});
        }
    }

    // Window activated
    private void addEventTeamsToTable() {
        DefaultTableModel dados = (DefaultTableModel) equipeTabela.getModel();
        dados.setNumRows(0);

        this.event.getTeams().forEach(team ->
                dados.addRow(new Object[]{
                        team.getId(),
                        team.getName(),
                        team.getProject(),
                        team.getClassroom(),
                        team.getPresented() ? "Sim" : "Não",
                        team.getMembersToString()
                }));
    }

    private void formWindowActivated() {
        addEventTeamsToTable();
    }

    // TeamRecordsPanel methods
    private void addMemberInTeam() {
        ((DefaultListModel<String>) equipeAlunosDaEquipeLista.getModel())
                .add(0, equipeAlunoTextField.getText());
        equipeAlunoTextField.setText("");
    }

    private void removeMemberFromTeam() {
        if (equipeAlunosDaEquipeLista.getSelectedIndex() == -1)
            JOptionPane.showMessageDialog(null, "Selecione um aluno para remover.");

        else
            ((DefaultListModel<String>) equipeAlunosDaEquipeLista.getModel())
                    .remove(equipeAlunosDaEquipeLista.getSelectedIndex());
    }

    private void cleanTeamRecordFields() {
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja limpar todos os campos?");
        if (confirm != 0) return;
        SwingUtils.cleanPanelRecordFields(equipeCadastro);
        activeTeamId = null;
    }

    private void createTeamInEvent() {
        if (equipeApresentouComboBox.getSelectedItem().toString().equals("Sim")) {
            JOptionPane.showMessageDialog(null, "Um novo time não pode ter apresentado.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja salvar a equipe?");
        if (confirm != 0) return;

        List<String> teamMembers = new ArrayList<>();
        for (int i = 0; i < equipeAlunosDaEquipeLista.getModel().getSize(); i++) {
            teamMembers.add(equipeAlunosDaEquipeLista.getModel().getElementAt(i));
        }

        TeamCreateDto teamCreateDto = new TeamCreateDto(
                equipeNomeTextField.getText(),
                equipeProjetoTextField.getText(),
                equipeTurmaComboBox.getSelectedItem().toString(),
                teamMembers
        );

        try {
            requestWithTokensRefreshing(() -> {
                this.event = this.presenterService.createTeamInEvent(teamCreateDto, this.event.getId(), this.userTokens);
                return null;
            });
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        finally {
            SwingUtils.cleanPanelRecordFields(equipeCadastro);
            activeTeamId = null;
        }

        JOptionPane.showMessageDialog(null, "Equipe cadastrada.");
    }

    private void updateTeam() {
        if (activeTeamId == null) {
            JOptionPane.showMessageDialog(null, "Equipe ainda não cadastrada.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja atualizar a equipe?");
        if (confirm != 0) return;

        List<String> teamMembers = new ArrayList<>();
        for (int i = 0; i < equipeAlunosDaEquipeLista.getModel().getSize(); i++) {
            teamMembers.add(equipeAlunosDaEquipeLista.getModel().getElementAt(i));
        }

        TeamUpdateDto teamUpdateDto = new TeamUpdateDto(
                equipeNomeTextField.getText(),
                equipeProjetoTextField.getText(),
                equipeTurmaComboBox.getSelectedItem().toString(),
                equipeApresentouComboBox.getSelectedItem().toString().equals("Sim"),
                teamMembers
        );

        try {
            requestWithTokensRefreshing(() -> {
                this.presenterService.updateTeam(teamUpdateDto, activeTeamId, this.userTokens);
                this.event = this.presenterService.findEventByJoinCode(this.event.getJoinCode(), this.userTokens);
                return null;
            });
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        finally {
            SwingUtils.cleanPanelRecordFields(equipeCadastro);
            activeTeamId = null;
        }

        JOptionPane.showMessageDialog(null, "Equipe atualizada.");
    }

    private void teamsTableRowClicked() {
        int rowIndex = equipeTabela.getSelectedRow() == -1 ? 1 : equipeTabela.getSelectedRow();
        activeTeamId = (long) equipeTabela.getValueAt(rowIndex, 0);
        equipeNomeTextField.setText(equipeTabela.getValueAt(rowIndex, 1).toString());
        equipeProjetoTextField.setText(equipeTabela.getValueAt(rowIndex, 2).toString());
        equipeTurmaComboBox.setSelectedItem(equipeTabela.getValueAt(rowIndex, 3).toString());
        equipeApresentouComboBox.setSelectedItem(equipeTabela.getValueAt(rowIndex, 4).toString());
        String[] members = equipeTabela.getValueAt(rowIndex, 5).toString()
                .replace(".", "")
                .split(", ");

        DefaultListModel<String> membersListModel = (DefaultListModel<String>) equipeAlunosDaEquipeLista.getModel();
        membersListModel.clear();
        Arrays.stream(members).forEach(membersListModel::addElement);
    }

    private void deleteTeam() {
        if (equipeTabela.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null, "Selecione a equipe para excluir.");

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir a equipe?");
        if (confirm != 0) return;

        try {
            requestWithTokensRefreshing(() -> {
                this.presenterService.deleteTeam(activeTeamId, this.userTokens);
                this.event = this.presenterService.findEventByJoinCode(this.event.getJoinCode(), this.userTokens);
                return null;
            });
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        finally {
            SwingUtils.cleanPanelRecordFields(equipeCadastro);
            activeTeamId = null;
        }

        JOptionPane.showMessageDialog(null, "Equipe excluída.");
    }

    private void teamsSearchFilter() {
        DefaultTableModel teamsTableData = (DefaultTableModel) equipeTabela.getModel();
        teamsTableData.setNumRows(0);

        String searchBy = equipePorComboBox.getSelectedItem().toString().toLowerCase();
        List<Team> searchTeams = new ArrayList<>();
        String value = equipePesquisaTextField.getText();

        if (value.equals("")){
            searchTeams = List.copyOf(this.event.getTeams());
        }
        else {
            switch (searchBy) {
                case "nome" ->
                        searchTeams = this.event.getTeams().stream()
                                .filter(x -> x.getName().contains(value)).collect(Collectors.toList());
                case "projeto" ->
                        searchTeams = this.event.getTeams().stream()
                                .filter(x -> x.getProject().contains(value)).collect(Collectors.toList());
                case "aluno" ->
                        searchTeams = this.event.getTeams().stream()
                                .filter(x -> x.getMembersToString().contains(value)).collect(Collectors.toList());
                default -> {}
            }
        }

        searchTeams.forEach(team -> {
            teamsTableData.addRow(new Object[]{
                    team.getId(),
                    team.getName(),
                    team.getProject(),
                    team.getClassroom(),
                    team.getPresented() ? "Sim" : "Não",
                    team.getMembersToString()
            });
        });
    }

    // TimerPanel methods
    private void playCountdownTimer(java.awt.event.MouseEvent evt) {
        String[] time = {"0", "0"};
        if (tempoDuracaoComboBox.getSelectedItem().toString().equals("Customizado")) {
            time[0] = tempoCustomTextField.getText().split(":")[0];
            time[1] = tempoCustomTextField.getText().split(":")[1];
        } else {
            time[0] = tempoDuracaoComboBox.getSelectedItem().toString().split(" ")[0];
        }

        tempoDeleteLabel.setVisible(true);
        tempoDuracaoPanel.setVisible(false);
        tempoPlayLabel.setVisible(false);
        tempoDivideBar.setVisible(false);
        tempoConfigPanel.setPreferredSize(new Dimension(615, 150));

        countdownTimer = new Timer(1000, new ActionListener() {
            int totalSeconds = TimerUtils.getTotalSeconds(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalSeconds <= 60) SwingUtils.setRedCountdown(whiteCircleLabel, redCircleLabel, tempoNumbers);
                countdownTimerOperation(totalSeconds);
                totalSeconds--;
            }
        });
        countdownTimer.start();
    }

    private void countdownTimerOperation(int totalSeconds) {
        tempoNumbers.setVisible(true);
        tempoNumbers.setText(TimerUtils.getCountdownLabel(totalSeconds));

        if (totalSeconds == 60) SwingUtils.setRedCountdown(whiteCircleLabel, redCircleLabel, tempoNumbers);

        if (totalSeconds <= 60 && totalSeconds >= 0) {
            oscillationTimer.stop();
            tempoNumbers.setVisible(true);
            oscillationTimer.start();
        }

        if (totalSeconds == 0) {
            countdownTimer.stop();
            oscillationTimer.stop();

            SwingUtils.setWhiteCountdown(whiteCircleLabel, redCircleLabel, tempoNumbers);

            tempoDuracaoPanel.setVisible(true);
            tempoDeleteLabel.setVisible(false);
            tempoPlayLabel.setVisible(true);
            tempoDivideBar.setVisible(true);
            tempoConfigPanel.setPreferredSize(new Dimension(615, 200));

            SoundsUtils.playTimeOutSound();
        }
    }

    public void countdownOscillation() {
        tempoNumbers.setVisible(false);
    }

    private void cancelCountdown(java.awt.event.MouseEvent evt) {
        countdownTimer.stop();
        oscillationTimer.stop();

        SwingUtils.setWhiteCountdown(whiteCircleLabel, redCircleLabel, tempoNumbers);

        tempoNumbers.setText("00:00");
        tempoNumbers.setVisible(true);

        tempoDuracaoPanel.setVisible(true);
        tempoDeleteLabel.setVisible(false);
        tempoPlayLabel.setVisible(true);
        tempoDivideBar.setVisible(true);
        tempoConfigPanel.setPreferredSize(new Dimension(615, 200));
    }

    // SorteadorPanel methods
    private void drawTeamToPresent(java.awt.event.MouseEvent evt) {
        if (this.event.getTeamsToPresent().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há mais equipes para apresentação.");
            return;
        }
        if (teamToPresentDrawTimer != null) teamToPresentDrawTimer.stop();
        teamToPresentDrawTimer = new Timer(100, new ActionListener() {
            int drawLabelLoops = 0;
            int drawIndex = event.getTeamsToPresent().size();

            @Override
            public void actionPerformed(ActionEvent e) {
                // Restart the names looping
                if (drawIndex == 0) {
                    drawIndex = event.getTeamsToPresent().size();
                }

                sorteadorEquipeLabel.setText(event.getTeamsToPresent().get(drawIndex - 1).getName());
                drawIndex--;
                drawLabelLoops++;

                if (drawLabelLoops == 20) {
                    teamToPresentDrawTimer.stop();
                    getTeamToPresentDrawResult();
                }
            }
        });
        teamToPresentDrawTimer.start();
    }

    public void getTeamToPresentDrawResult() {
        int max = this.event.getTeamsToPresent().size();
        int random = (int) Math.floor(Math.random() * max);
        String chosenTeam = this.event.getTeamsToPresent().get(random).getName();
        sorteadorEquipeLabel.setText(chosenTeam);
    }

    private void confirmPresentation(java.awt.event.MouseEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(null, "Confirmar apresentação da equipe?");
        if (confirm != 0) return;

        Team team = this.event.getTeams().stream()
                .filter(x -> x.getName().equals(sorteadorEquipeLabel.getText()))
                .findFirst().orElseThrow(() -> new RuntimeException("Nenhuma equipe restante."));
        team.setPresented(true);

        try {
            requestWithTokensRefreshing(() -> {
                presenterService.updateTeam(new TeamUpdateDto(team), team.getId(), this.userTokens);
                this.event = presenterService.findEventByJoinCode(this.event.getJoinCode(), this.userTokens);
                return null;
            });
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

        setTeamsDrawLabel();
        sorteadorEquipeLabel.setText("Equipe Selecionada");

        JOptionPane.showMessageDialog(null, "Apresentação registrada.");
    }

    private void cancelPresentation(java.awt.event.MouseEvent evt) {
        int confirm = JOptionPane.showConfirmDialog(null, "Confirmar problema na apresentação da equipe?");
        if (confirm == 0) {
            sorteadorEquipeLabel.setText("Equipe Selecionada");
            JOptionPane.showMessageDialog(null, "Erro na apresentação confirmado.");
        }
    }

    private javax.swing.JPanel abaEquipes;
    private javax.swing.JPanel abaRanking;
    private javax.swing.JPanel abaSorteador;
    private javax.swing.JPanel abaTemporizador;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel equipeAddAlunoBotao;
    private javax.swing.JLabel equipeAlunoLabel;
    private javax.swing.JTextField equipeAlunoTextField;
    private javax.swing.JScrollPane equipeAlunosDaEquipeContentPanel;
    private javax.swing.JList<String> equipeAlunosDaEquipeLista;
    private javax.swing.JComboBox<String> equipeApresentouComboBox;
    private javax.swing.JLabel equipeApresentouLabel;
    private javax.swing.JPanel equipeCadastro;
    private javax.swing.JPanel equipeDivideBar;
    private javax.swing.JLabel equipeEditarBotao;
    private javax.swing.JLabel equipeExcluirBotao;
    private javax.swing.JLabel equipeNomeLabel;
    private javax.swing.JTextField equipeNomeTextField;
    private javax.swing.JLabel equipeNovaBotao;
    private javax.swing.JPanel equipePesquisaBar;
    private javax.swing.JLabel equipePesquisaLabel;
    private javax.swing.JPanel equipePesquisaPanel;
    private javax.swing.JTextField equipePesquisaTextField;
    private javax.swing.JComboBox<String> equipePorComboBox;
    private javax.swing.JLabel equipePorLabel;
    private javax.swing.JLabel equipeProjetoLabel;
    private javax.swing.JTextField equipeProjetoTextField;
    private javax.swing.JLabel equipeRemoveAlunoBotao;
    private javax.swing.JLabel equipeSalvarBotao;
    private javax.swing.JTable equipeTabela;
    private javax.swing.JScrollPane equipeTabelaContent;
    private javax.swing.JPanel equipeTabelaPanel;
    private javax.swing.JComboBox<String> equipeTurmaComboBox;
    private javax.swing.JLabel equipeTurmaLabel;
    private javax.swing.JPanel equipesActivePanel;
    private javax.swing.JLabel equipesMenuLabel;
    private javax.swing.JLabel inMenuBarSpaceLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainbarSpaceLabel;
    private javax.swing.JPanel menuBar;
    private javax.swing.JLabel menuFundoLargo;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JPanel menuRightPanel;
    private javax.swing.JLabel minemizeLabel;
    private javax.swing.JLabel presenterLabel;
    private javax.swing.JPanel programBar;
    private javax.swing.JPanel rankingHeadPanel;
    private javax.swing.JPanel rankingMenuActivePanel;
    private javax.swing.JLabel rankingMenuLabel;
    private javax.swing.JTable rankingTabela;
    private javax.swing.JScrollPane rankingTabelaContent;
    private javax.swing.JPanel rankingTablePanel;
    private javax.swing.JLabel redCircleLabel;
    private javax.swing.JLabel relatorioAtrasoLabel;
    private javax.swing.JLabel sorteadorApresentouLabel;
    private javax.swing.JLabel sorteadorEquipeLabel;
    private javax.swing.JPanel sorteadorEquipePanel;
    private javax.swing.JLabel sorteadorEquipesRestandoLabel;
    private javax.swing.JPanel sorteadorMenuActivePanel;
    private javax.swing.JLabel sorteadorMenuLabel;
    private javax.swing.JLabel sorteadorNaoAprensentouLabel;
    private javax.swing.JLabel sorteadorSortearBotao;
    private javax.swing.JPanel sorteadorSortearPanel;
    private javax.swing.JPanel sorteioDivideBar;
    private javax.swing.JLabel space;
    private javax.swing.JLabel tempMenuLabel;
    private javax.swing.JPanel tempoActionsPanel;
    private javax.swing.JPanel tempoAreaPanel;
    private javax.swing.JPanel tempoConfigPanel;
    private javax.swing.JLabel tempoCustomLabel;
    private javax.swing.JFormattedTextField tempoCustomTextField;
    private javax.swing.JLabel tempoDeleteLabel;
    private javax.swing.JPanel tempoDivideBar;
    private javax.swing.JComboBox<String> tempoDuracaoComboBox;
    private javax.swing.JPanel tempoDuracaoPanel;
    private javax.swing.JLabel tempoMinutesLabel;
    private javax.swing.JLabel tempoNumbers;
    private javax.swing.JLabel tempoPlayLabel;
    private javax.swing.JLabel tempoTempoLabel;
    private javax.swing.JPanel temporizadorActivePanel;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel titleBarSpaceLabel;
    private javax.swing.JLabel whiteCircleLabel;
}
