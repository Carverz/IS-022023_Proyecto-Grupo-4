package main.views;

import main.models.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;

public class MakeExamView extends JFrame {
    private ArrayList<Question> questions;
    private JTextField durationTextField;
    private JTextField domainTextField;
    private JTextArea questionTextArea;
    private JTextArea answerTextArea;
    private JTextArea justificationTextArea;
    private JButton fileChooserButton;
    private JButton addQuestionButton;
    private JButton generateExamButton;
    private String pathImg = "";


    public MakeExamView() {
        questions = new ArrayList<>();

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Configuración de la interfaz de usuario
        setLocationRelativeTo(null);
        setTitle("Crear Examen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel durationLabel = new JLabel("Duración del examen (minutos):");
        durationTextField = new JTextField(10);
        JLabel domainLabel = new JLabel("Dominio de la pregunta:");

        domainTextField = new JTextField(10);
        JLabel questionLabel = new JLabel("Pregunta:");
        questionTextArea = new JTextArea();
        JScrollPane questionScrollPane = new JScrollPane(questionTextArea);

        JLabel answerLabel = new JLabel("Respuestas (una por línea):");
        answerTextArea = new JTextArea();
        JScrollPane answerScrollPane = new JScrollPane(answerTextArea);

        JLabel justLabel = new JLabel("Justificacion");
        justificationTextArea = new JTextArea();
        JScrollPane justificationScrollPane = new JScrollPane(justificationTextArea);

        JLabel imageLabel = new JLabel("Imagen para la pregunta: ");

        addQuestionButton = new JButton("Agregar Pregunta");
        generateExamButton = new JButton("Generar Examen");
        fileChooserButton = new JButton("Seleccionar Imagen");

        inputPanel.add(durationLabel);
        inputPanel.add(durationTextField);
        inputPanel.add(domainLabel);
        inputPanel.add(domainTextField);
        inputPanel.add(questionLabel);
        inputPanel.add(questionScrollPane);
        inputPanel.add(answerLabel);
        inputPanel.add(answerScrollPane);
        inputPanel.add(justLabel);
        inputPanel.add(justificationScrollPane);
        inputPanel.add(imageLabel);
        inputPanel.add(fileChooserButton);
        inputPanel.add(addQuestionButton);
        inputPanel.add(generateExamButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JTextArea questionsTextArea = new JTextArea();
        questionsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(questionsTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (questionTextArea.getText().isEmpty() || justificationTextArea.getText().isEmpty()
                        || answerTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la información.", "Campo obligatorio",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    String questionText = questionTextArea.getText();
                    String justificationText = justificationTextArea.getText();
                    String[] answerLines = answerTextArea.getText().split("\n");
                    String[] trueOrFalse;
                    int[] isCorrect = new int[answerLines.length];
                    int con = 0;

                    for (int i = 0; i < answerLines.length; i++) {
                        trueOrFalse = answerLines[i].split(":");
                        if (trueOrFalse.length > 1 && (trueOrFalse[1].equals("V") || trueOrFalse[1].equals("v"))) {
                            isCorrect[con] = i;
                            con++;
                        }
                    }

                    // IMPRESION DE PRUEBA
                    // System.out.print("Indices de las preguntas correctas: ");
                    // for (int i = 0; i < con; i++) {
                    // System.out.print(isCorrect[i] + " ");
                    // }
                    // System.out.println();
                    ////////////////////////////////

                    ArrayList<Answer> answers = new ArrayList<>();
                    for (int i = 0, j = 0, m = 0; i < answerLines.length; i++) {
                        if (i == isCorrect[m]) {
                            Answer answer;
                            if (answerLines[j].contains(":V")) {
                                answer = new Answer(answerLines[j].replaceAll(":V", ""), true);
                                answers.add(answer);
                                j++;
                            } else if (answerLines[j].contains(":v")) {
                                answer = new Answer(answerLines[j].replaceAll(":v", ""), true);
                                answers.add(answer);
                                j++;
                            }
                            m++;
                        } else {
                            Answer answer = new Answer(answerLines[j], false);
                            answers.add(answer);
                            j++;
                        }
                    }

                    String domainText = domainTextField.getText();
                    // question.setStatement(questionText);
                    // question.setAnswer(answers);
                    // question.setJust(justificationText);
                    // question.setDomain(domainText);
                    Question question = new Question(questionText,answers,justificationText,domainText);
                    question.setImg(pathImg);
                    questions.add(question);
                    pathImg = "";

                    // Mostrar las preguntas en el área de texto
                    questionsTextArea.append("Pregunta: " + questionText + "\n");
                    questionsTextArea.append("Respuestas:\n");
                    for (Answer answer : answers) {
                        questionsTextArea.append("- " + answer.getText() + "\n");
                    }
                    justificationTextArea.append("Justificacion: " + justificationText + "\n");
                    questionsTextArea.append(question.getImg());
                    questionsTextArea.append("\n");

                    // Limpiar los campos de texto
                    domainTextField.setText("");
                    domainTextField.setText("");
                    questionTextArea.setText("");
                    answerTextArea.setText("");
                    justificationTextArea.setText("");
                    System.out.println(question.getImg());
                }
            }
        });

        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg, jpeg & png", "jpg", "png", "jpeg");
                fileChooser.setFileFilter(filter);
                int resp = fileChooser.showOpenDialog(null);
                if (resp == JFileChooser.APPROVE_OPTION) {
                    // if(questions.size() != 0){
                        pathImg = fileChooser.getSelectedFile().getPath();
                        // questions.get(questions.size()-1).setImg(pathImg);
                    // }else{
                    //     pathImg = fileChooser.getSelectedFile().getPath();
                    // }
                    //question.setImg(pathImg);
                }
            }
        });

        generateExamButton.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                if (durationTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la duracion del examen.",
                            "Campo obligatorio",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String examName;
                    examName = (JOptionPane.showInputDialog("Nombre del Examen: "));
                    int duration = Integer.parseInt(durationTextField.getText());

                    Exam exam = new Exam(questions, duration, examName);

                    JSONObject examObject = exam.toJSON();
                    JSONArray examenes = new JSONArray();
                    examenes.add(examObject);

                    try {
                        FileWriter file = new FileWriter("src\\data\\" + examName + ".json");
                        file.append(examenes.toJSONString());
                        file.flush();
                        file.close();
                    } catch (IOException a) {
                        a.printStackTrace();
                    }

                    // Limpiar las preguntas y el área de texto
                    questions.clear();
                    questionsTextArea.setText("");

                    // Limpiar los campos de texto
                    durationTextField.setText("");
                    domainTextField.setText("");
                    questionTextArea.setText("");
                    answerTextArea.setText("");
                    justificationTextArea.setText("");

                    JOptionPane.showMessageDialog(MakeExamView.this, "Examen generado exitosamente", "Examen Generado",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MakeExamView();
    }
}