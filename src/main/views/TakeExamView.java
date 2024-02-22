
package main.views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import main.controllers.TakeExamController;
import javax.swing.JOptionPane;
import main.models.Answer;
import main.models.Question;
import main.models.Exam;


public class TakeExamView extends javax.swing.JFrame implements ActionListener {

   private List<JRadioButton> buttons;
   //private ButtonGroup group;
   private Timer temporizador;
   public int minute;
   public int hour;
   public int second;
   private TakeExamController controller;
   private int index;
   private TakeExamView prevView;
   private TakeExamView nextView;
   private int seleccionMax;
   private int seleccion;
   private int seleccionPrev;
   
    public TakeExamView(TakeExamController controller,int index) {
        hour = controller.gethour();
       minute = controller.getminute();
       second =controller.getsecond();
       this.controller = controller;
       this.index = index;
        initComponents();
        enunciado.setText(controller.getStatement(index));
        questNumber.setText("Pregunta "+(index+1));
        setTextTimer();
        iniRadioButtons();
        iniTimer();
        iniSeleccionMax();
        seleccionPrev=0;
  
       
       if(this.index==0)
           back.setEnabled(false);
       
       if(this.index==controller.getQuestNumber()-1)
           next.setEnabled(false);
       
       progress.setValue((100/controller.getQuestNumber())*(index+1));
       
    }
    
    public TakeExamView(TakeExamController controller,int index,TakeExamView prevView,int seleccionPrev){
  
        this.prevView = prevView;
       this.controller = controller;
       this.index = index;
       this.seleccionPrev = seleccionPrev;
        initComponents();
        enunciado.setText(controller.getStatement(index));
        questNumber.setText("Pregunta "+(index+1));
       this.setTextTimer();
       this.iniRadioButtons();
       prevTimer();
       iniSeleccionMax();
         
       if(this.index==0)
           back.setEnabled(false);
       
       if(this.index==controller.getQuestNumber()-1)
           next.setEnabled(false);
       
       progress.setValue((100/controller.getQuestNumber())*(index+1));
       
    }
    
    private void iniSeleccionMax(){
        seleccionMax = 0;
        for(int i=0;i<controller.getIterator(index);i++){
            if(controller.getRightAnswer(index, i)==true)
                seleccionMax++;
        }
        System.out.print(seleccionMax);
    }
    
    public void setTextTimer(){
        quest.setText((index+1)+" Preguntas");
        ans.setText(controller.ansNumber()+" Respuestas");
    }
    
    private void iniRadioButtons(){
      //  group = new ButtonGroup();
       buttons = new ArrayList<>();
       for(int i=0;i<controller.getIterator(index);i++){
           JRadioButton boton = new JRadioButton(controller.getTextAnswer(index, i));
           panel.add(boton);
           buttons.add(i, boton);
        //   group.add(boton);
           boton.addActionListener(this);
           
       }
    }
    
    public int getHour(){
        return this.hour;
    }
    
    public int getMinute(){
        return this.minute;
    }
    
    public int getSecond(){
        return this.second;
    }
    
    private void iniTimer(){
        
       
       timer.setText(((hour>9)?hour:"0"+hour)+":"+((minute>9)?minute:"0"+minute)+":"+((second>9)?second:"0"+second));       
       
       temporizador = new Timer(1000,null);
       temporizador.start();
       temporizador.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent evt){
               
               timer.setText(((hour>9)?hour:"0"+hour)+":"+((minute>9)?minute:"0"+minute)+":"+((second>9)?second:"0"+second));
                
               if(hour==0&&minute==0&&second==0){
                temporizador.stop();
                return;
               }
               if(second==0){
                   second = 59;
                  if(minute==0){
                      
                      minute = 59;
                      hour--;
                      
                  }else{ 
                      
                      minute--;}
                  
               }else second--;
     
           }
       });
    }
    
    private void prevTimer(){
        
       timer.setText(((hour>9)?hour:"0"+hour)+":"+((minute>9)?minute:"0"+minute)+":"+((second>9)?second:"0"+second));       
       
       temporizador = new Timer(1000,null);
       temporizador.start();
       temporizador.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent evt){
               
               hour = prevView.getHour();
               minute = prevView.getMinute();
               second = prevView.getSecond();
               
               timer.setText(((prevView.getHour()>9)?prevView.getHour():"0"+prevView.getHour())+":"+((prevView.getMinute()>9)?prevView.getMinute():"0"+prevView.getMinute())+":"+((prevView.getSecond()>9)?prevView.getSecond():"0"+prevView.getSecond()));
    }
               });
    }
   
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        questNumber = new javax.swing.JLabel();
        enunciado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        quest = new javax.swing.JLabel();
        ans = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        done = new javax.swing.JButton();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        questNumber.setText("jLabel3");

        enunciado.setBackground(new java.awt.Color(255, 255, 255));
        enunciado.setText("jLabel2");
        enunciado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Respuesta:");

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(panel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        quest.setText("jLabel4");

        ans.setText("jLabel5");

        jLabel6.setText("TIEMPO");

        timer.setText("jLabel7");

        done.setText("TERMINAR");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timer)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quest)
                            .addComponent(done)
                            .addComponent(ans))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quest)
                .addGap(18, 18, 18)
                .addComponent(ans)
                .addGap(57, 57, 57)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(timer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(done)
                .addGap(35, 35, 35))
        );

        back.setText("ANTERIOR");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        next.setText("SIGUIENTE");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        progress.setToolTipText("PROGRESO");
        progress.setName("progeso"); // NOI18N
        progress.setString("PROGRESO");
        progress.setStringPainted(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ayuda!!!");

        jButton3.setText("Perfil");

        jButton4.setText("Cerrar Sesion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(0, 0, 0)
                .addComponent(jButton4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(enunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(questNumber)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(enunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(back))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        int k=seleccionPrev;
      
      for(int i=0;i<controller.getIterator(index);i++){
          if(buttons.get(i).isSelected()==true){
              controller.setRespuesta(controller.getRightAnswer(index,i),k);
              k++;
          }
              
      }
      
       if(this.nextView == null)
          this.nextView = new TakeExamView(controller,index+1,this,k);
      
      this.nextView.setVisible(true);
      this.nextView.setTextTimer();
      
      
       this.dispose();
    }//GEN-LAST:event_nextActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        prevView.setVisible(true);
        this.setTextTimer();
        this.dispose();
        prevView.setTextTimer();
    }//GEN-LAST:event_backActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
       int confirmacion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea terminar el exame?",null,JOptionPane.YES_NO_OPTION);
       if(confirmacion == JOptionPane.YES_OPTION)
           dispose();
       
    }//GEN-LAST:event_doneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(TakeExamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeExamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeExamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeExamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Answer> a = new ArrayList<>();
                
                a.add(new Answer("respuesta 1",false));
                a.add(new Answer("respuesta 2",true));
                a.add(new Answer("respuesta 3",false));
                a.add(new Answer("respuesta 4",true));
                
                ArrayList<Answer> a2 = new ArrayList<>();
                
                a2.add(new Answer("respuesta 5",false));
                a2.add(new Answer("respuesta 6",true));
                a2.add(new Answer("respuesta 7",false));
                a2.add(new Answer("respuesta 8",false));
                a2.add(new Answer("respuesta 9",false));
                
                ArrayList<Answer> a3 = new ArrayList<>();
                
                a3.add(new Answer("respuesta 10",false));
                a3.add(new Answer("respuesta 11",true));
                a3.add(new Answer("respuesta 12",true));
                a3.add(new Answer("respuesta 13",true));
                a3.add(new Answer("respuesta 14",false));
                
                ArrayList<Question> b = new ArrayList<>();
                b.add(new Question("¿Cual es la pregunta 1?",a));
                b.add(new Question("¿Cual es la pregunta 2?",a2));
                b.add(new Question("¿Cual es la pregunta 3?",a3));
                
                
                
                //Exam c = new Exam(b,1,"");
                
                //TakeExamController controller = new TakeExamController(c);
                
               // new ExamView(controller,0).setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ans;
    private javax.swing.JButton back;
    private javax.swing.JButton done;
    private javax.swing.JLabel enunciado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JPanel panel;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel quest;
    private javax.swing.JLabel questNumber;
    private javax.swing.JLabel timer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(seleccion==seleccionMax){
             //JRadioButton aux;
             //aux = null;
             int aux =-1;
            for(int i=0;i<controller.getIterator(index);i++){
                
                if(e.getSource()==buttons.get(i)){
                if(buttons.get(i).isSelected()==false){
                    seleccion--;
                    System.out.print(seleccion);
                    return;
                }
                setTextTimer();
                 
              
                }
                if(buttons.get(i).isSelected()==true&&e.getSource()!=buttons.get(i)){
                    aux = i;
                
                
                }
             
                //controller.setRespuesta(controller.getRightAnswer(index,i));
                //controller.setRespuesta(controller.getRightAnswer(index,i),index);
                //System.out.print(controller.respuesta.get(index));
               
                
        }
            buttons.get(aux).setSelected(false);
            
            return;
           
        }
      if(seleccion<seleccionMax)
        for(int i=0;i<controller.getIterator(index);i++){
            if(e.getSource()==buttons.get(i)){
                if(buttons.get(i).isSelected()==true){
                    seleccion++;
                }else seleccion--;
                
                if(controller.getRespuestaSize()<seleccionMax)
                controller.setRespuesta(false);
                //controller.setRespuesta(controller.getRightAnswer(index,i),index);
                //System.out.print(controller.respuesta.get(index));
                
            }    
        }
        setTextTimer();
        System.out.print(seleccion);
    }
}
