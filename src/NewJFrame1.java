import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
/**
 *
 * @author jinang_shah
 */
public class NewJFrame1 extends javax.swing.JFrame {

    
    String s,algo;
    int head;
    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
    }
    
    public int substract(int a,int b){
	if(a>b)
	    return(a-b);
	else
	    return(b-a);    
    }
    
    public int[] sstf(int a[]){
        
        int [] done=new int[20];
        int [] sstf=new int[20];
        int i,l,column=0,temp,j=0;
        int nearest= substract(a[0],a[1]);
        sstf[0]=a[0];
        temp=a[0];
        
        for(i=0;i<a.length;i++)
            done[i]=0;
        
   
	for(i=1;i<a.length;i++){

		l=1;     
		while(l<10 && done[l]!=0){
			l++;
		}
		     			 
		nearest=substract(a[l],temp);	      
				    
   		for(j=1;j<a.length;j++){
   	   		if(done[j]!=1 && (substract(a[j],temp)<=nearest) && (substract(a[j],temp)!=0)){     	   	 	   	  		
   	   	      		nearest=substract(a[j],temp); 
   	   	      		column=j;					  	  					
			}
   		}
   		done[column]=1; 
   		sstf[i]= a[column];
   		temp=sstf[i];  		 		 
        }
        
        for(i=0;i<a.length;i++)
            a[i]=sstf[i];
        
        return a;
    }
    
static int[] scan(int arr[], int head, String direction)
{
    int size=arr.length;
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+2];
    list.add(head);
    // appending end values
    // which has to be visited
    // before reversing the direction
    if (direction == "left")
        left.add(0);
    else if (direction == "right")
        right.add(199);
 
    for (int i = 0; i < size; i++) 
    {
        if (arr[i] < head)
            left.add(arr[i]);
        if (arr[i] > head)
            right.add(arr[i]);
    }
 
    // sorting left and right vectors
    Collections.sort(left);
    Collections.sort(right);
 
    // run the while loop two times.
    // one by one scanning right
    // and left of the head
    int run = 2;
    while (run-- >0)
    {
        if (direction == "left") 
        {
            for (int i = left.size() - 1; i >= 0; i--) 
            {
                cur_track = left.get(i);
 
                // appending current track to seek sequence
                seek_sequence.add(cur_track);
                // calculate absolute distance
                distance = Math.abs(cur_track - head);
                // increase the total count
                seek_count += distance;
                // accessed track is now the new head
                head = cur_track;
            }
            direction = "right";
        }
        else if (direction == "right") 
        {
            for (int i = 0; i < right.size(); i++) 
            {
                cur_track = right.get(i);                
                // appending current track to seek sequence
                seek_sequence.add(cur_track);
                // calculate absolute distance
                distance = Math.abs(cur_track - head);
                // increase the total count
                seek_count += distance; 
                // accessed track is now new head
                head = cur_track;
            }
            direction = "left";
        }
    }
 
    
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
        System.out.println(a[i]);
    }
    
    return a;
}

static int[] cscan(int arr[], int head) 
{ 
    int size=arr.length;
    int seek_count = 0; 
    int distance, cur_track; 
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>(); 
    Vector<Integer> seek_sequence = new Vector<Integer>(); 
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+3];
    list.add(head);
    
    // appending end values 
    // which has to be visited 
    // before reversing the direction 
    left.add(0); 
    right.add(199); 
  
    // tracks on the left of the 
    // head will be serviced when 
    // once the head comes back 
    // to the beggining (left end). 
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 
  
    // sorting left and right vectors 
    Collections.sort(left);
    Collections.sort(right); 
  
    // first service the requests 
    // on the right side of the 
    // head. 
    for (int i = 0; i < right.size(); i++) { 
        cur_track = right.get(i); 
        // appending current track to seek sequence 
        seek_sequence.add(cur_track); 
  
        // calculate absolute distance 
        distance = Math.abs(cur_track - head); 
  
        // increase the total count 
        seek_count += distance; 
  
        // accessed track is now new head 
        head = cur_track; 
    } 
  
    // once reached the right end 
    // jump to the beggining. 
    head = 0; 
  
    // Now service the requests again 
    // which are left. 
    for (int i = 0; i < left.size(); i++) { 
        cur_track = left.get(i); 
  
        // appending current track to seek sequence 
        seek_sequence.add(cur_track); 
  
        // calculate absolute distance 
        distance = Math.abs(cur_track - head); 
  
        // increase the total count 
        seek_count += distance; 
  
        // accessed track is now the new head 
        head = cur_track; 
    } 
 
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
        System.out.println(a[i]);
    }
    
    return a; 
} 

static int[] look(int arr[], int head, String direction)
{
    int size=arr.length;
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+1];
    list.add(head);
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 
  
    // sorting left and right vectors 
    // for servicing tracks in the 
    // correct sequence. 
    Collections.sort(left);
    Collections.sort(right);
  
    // run the while loop two times. 
    // one by one scanning right 
    // and left side of the head 
    int run = 2; 
    while (run>0) { 
        if (direction == "left") { 
            for (int i = left.size() - 1; i >= 0; i--) { 
                cur_track = left.get(i); 
  
                // appending current track to seek sequence 
                seek_sequence.add(cur_track); 
  
                // calculate absolute distance 
                distance = Math.abs(cur_track - head); 
  
                // increase the total count 
                seek_count += distance; 
  
                // accessed track is now the new head 
                head = cur_track; 
            } 
            // reversing the direction 
            direction = "right"; 
        } 
        else if (direction == "right") { 
            for (int i = 0; i < right.size(); i++) { 
                cur_track = right.get(i); 
                // appending current track to seek sequence 
                seek_sequence.add(cur_track); 
  
                // calculate absolute distance 
                distance = Math.abs(cur_track - head); 
  
                // increase the total count 
                seek_count += distance; 
  
                // accessed track is now new head 
                head = cur_track; 
            } 
            // reversing the direction 
            direction = "left"; 
        } 
        
       run--;
    } 
 
    
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
    }
    
    return a;
}

static int[] clook(int arr[], int head) 
{ 
    int size=arr.length;
    int seek_count = 0; 
    int distance, cur_track; 
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+1];
    list.add(head); 
  
    // Tracks on the left of the 
    // head will be serviced when 
    // once the head comes back 
    // to the beggining (left end) 
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 
  
    // Sorting left and right vectors 
    Collections.sort(left);
    Collections.sort(right);
  
    // First service the requests 
    // on the right side of the 
    // head 
    for (int i = 0; i < right.size(); i++) { 
        cur_track = right.get(i); 
  
        // Appending current track to seek sequence 
        seek_sequence.add(cur_track); 
  
        // Calculate absolute distance 
        distance = Math.abs(cur_track - head); 
  
        // Increase the total count 
        seek_count += distance; 
  
        // Accessed track is now new head 
        head = cur_track; 
    } 
  
    // Once reached the right end 
    // jump to the last track that 
    // is needed to be serviced in 
    // left direction 
    seek_count += Math.abs(head - left.get(0)); 
    head = left.get(0); 
  
    // Now service the requests again 
    // which are left 
    for (int i = 0; i < left.size(); i++) { 
        cur_track = left.get(i); 
  
        // Appending current track to seek sequence 
        seek_sequence.add(cur_track); 
  
        // Calculate absolute distance 
        distance = Math.abs(cur_track - head); 
  
        // Increase the total count 
        seek_count += distance; 
  
        // Accessed track is now the new head 
        head = cur_track; 
    } 
    
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
    }
    
    return a;
  
    
} 
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DISK SCHEDULING");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 204, 24));

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DISK SCHEDULING");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 78));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Request Queue :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 24));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Algorithm :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 18));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SSTF", "SCAN", "C SCAN", "LOOK", "C LOOK" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("R/W Head Position :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 60, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        s=jTextField1.getText();
        head=Integer.parseInt(jTextField2.getText());
        String[] strArray = s.split(",");
        
        
        if(algo=="FCFS"){
            int [] a = new int[strArray.length+1];
            int [] b = new int[strArray.length+1];

            ArrayList<Integer> list = new ArrayList<Integer>(strArray.length+1);     //150,190,60,30,10
            list.add(head);
            for(int i=0;i<strArray.length;i++){
               list.add(Integer.parseInt(strArray[i]));
            }
        
            for(int i=0;i<list.size();i++){
                a[i]=list.get(i);
            }

            b=a;
            a=a;
            new NewJFrame2(a,b).setVisible(true);
            this.setVisible(false);
        }
        
        else if(algo=="SSTF"){
            int [] a = new int[strArray.length+1];
            int [] b = new int[strArray.length+1];

            ArrayList<Integer> list = new ArrayList<Integer>(strArray.length+1);
            list.add(head);
            for(int i=0;i<strArray.length;i++){
               list.add(Integer.parseInt(strArray[i]));
            }
        
            for(int i=0;i<list.size();i++){
                a[i]=list.get(i);
            }

            b=a;
            a=sstf(a);
            new NewJFrame2(a,b).setVisible(true);
            this.setVisible(false);
        }
        
        else if(algo=="SCAN"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+2];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=scan(a,head,"left");
            new NewJFrame2(c,c).setVisible(true);
            this.setVisible(false);
        }
        
        
        else if(algo=="C SCAN"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+3];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=cscan(a,head);
            new NewJFrame2(c,c).setVisible(true);
            this.setVisible(false);
        }
        
         else if(algo=="LOOK"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+1];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=look(a,head,"left");
            new NewJFrame2(c,c).setVisible(true);
            this.setVisible(false);
        }
        
        else if(algo=="C LOOK"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+1];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=clook(a,head);
            new NewJFrame2(c,c).setVisible(true);
            this.setVisible(false);
        }
             
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedItem() != null) {
            algo=jComboBox1.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
