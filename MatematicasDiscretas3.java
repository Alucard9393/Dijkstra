
package matematicasdiscretas2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;

public class MatematicasDiscretas3 extends JFrame
{
    JLabel titulo,titulo2,titulo3;
    JTextField vertices= new JTextField();   
    JComboBox incio=new JComboBox();
    JTable jttabla,jttabla2,jttabla3;
    JScrollPane scptabla,scptabla2,scptabla3;
    DefaultTableModel tablax,tablax2;
    JButton Aceptar,Aceptar2,Aceptar3; int  vertic,numero; 
    JTextArea areaEscribe;
    JScrollPane scrool;
    boolean entro=false;
    public MatematicasDiscretas3()
    { 
        super("Matematicas Discretas 3");
        setLayout(null);
        
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/ix.png")).getImage();
        setIconImage(icon);
        
        titulo=new JLabel("Numero de vertices");
        titulo.setFont(new java.awt.Font("Lucida Console", 0, 13));
        titulo.setBounds(20,17,150,20);          
        add(titulo);
        
        vertices=new JTextField();       
        vertices.setBounds(175,17,30,20);
        vertices.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e)
            {
                char caracter = e.getKeyChar();
                if(((caracter < '0') || 
                (caracter > '9')) &&
                (caracter != KeyEvent.VK_BACK_SPACE)){
                    e.consume();
                }
                if (vertices.getText().length()>=2)
                    e.consume();
                }
            });
        add(vertices); 
        
        titulo3=new JLabel();
        titulo3.setFont(new java.awt.Font("Lucida Console", 0, 13));
        titulo3.setBounds(20,68,480,20);          
        add(titulo3);
        
        jttabla=new JTable();
        jttabla=new javax.swing.JTable(){
        public boolean isCellEditable(int rowIndex,int colIndex){
            return true;
        }
        };
        scptabla=new JScrollPane();
        scptabla.setViewportView(jttabla);
        
        jttabla2=new JTable(tablax);
        jttabla2=new javax.swing.JTable(tablax)
        {
                @Override
                public boolean isCellEditable(int rowIndex,int colIndex)
                {
                //System.out.println("CLick en "+rowIndex+" "+colIndex);
                        if(colIndex==0)
                        {
                         return false;
                        }
                        else
                        {
                         return true;
                        }
                }
                @Override
                public void changeSelection(int rowIndex, int columnIndex,boolean toggle, boolean extend) 
                {
				if (columnIndex == 0)
                                {
					super.changeSelection(rowIndex, columnIndex + 1, toggle,extend);
                                }
				else
                                {
					super.changeSelection(rowIndex, columnIndex, toggle,extend);
                                }          
		}
                
        };       
        
        scptabla2=new JScrollPane();
        scptabla2.setViewportView(jttabla2);
        
        jttabla3=new JTable(tablax2);
        jttabla3=new javax.swing.JTable(tablax2)
        {
                @Override
                public boolean isCellEditable(int rowIndex,int colIndex)
                {
                    System.out.println("CLick en "+rowIndex+" "+colIndex);
                         return false;
                }
                @Override
                public void changeSelection(int rowIndex, int columnIndex,boolean toggle, boolean extend) 
                {
				if (columnIndex == 0)
                                {
					super.changeSelection(rowIndex, columnIndex + 1, toggle,extend);
                                }
				else
                                {
					super.changeSelection(rowIndex, columnIndex, toggle,extend);
                                }          
		}
                
        };
        
        scptabla3=new JScrollPane();
        scptabla3.setViewportView(jttabla3);
        
        Aceptar = new JButton("Aceptar");
        Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aceptar.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        Aceptar.setFont(new java.awt.Font("Lucida Console", 0, 13));
        Aceptar.setBounds(220,15,120,25);
        add(Aceptar);
        ManejadorBoton1 manejador = new ManejadorBoton1();
        Aceptar.addActionListener( manejador );
        
        titulo2=new JLabel();
        titulo2.setFont(new java.awt.Font("Lucida Console", 0, 13));
        titulo2.setBounds(20,180,480,20);          
        add(titulo2);
        
        incio= new JComboBox();
                
        areaEscribe = new JTextArea();
        scrool = new JScrollPane(areaEscribe); 
        
        Aceptar3 = new JButton("Aceptar");
        Aceptar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aceptar3.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        Aceptar3.setFont(new java.awt.Font("Lucida Console", 0, 13));
        ManejadorBoton3 manejador3 = new ManejadorBoton3();
        Aceptar3.addActionListener( manejador3 );
    }
    
    private class ManejadorBoton1 implements ActionListener 
    {    
       public void actionPerformed( ActionEvent evento )
       { 
          if(!"".equals(vertices.getText()))
          { 
              
                    String x=vertices.getText();
                    vertic=Integer.parseInt(x);
                    
                    titulo3.setText("Renombre  los "+vertic+" vertices en cada cuadro");
                    titulo3.setVisible(true);  
                           /*  jttabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                           jttabla.setModel(new javax.swing.table.DefaultTableModel(
                                new Object [][] {

                                },
                                new String [] {

                                }
                            ));*/
                            
                            //se crea un JScrollPane para poder agregar al el la tabla y visualizarla
                            
                            
                    DefaultTableModel tabla= new DefaultTableModel();
                    int num=1;
                    String datos[]=new String [vertic];
                    for(int i=0;i<vertic;i++)
                    { 
                        if(vertic>7)
                        {
                           tabla.addColumn("V"+num); 
                           datos[i]="Vec"+num;
                        }
                        else
                        {
                          tabla.addColumn("Nombre V"+num); 
                          datos[i]="Vec"+num;
                        }num++;
                          
                    }  num=1;                     
                    
                    
                    tabla.addRow(datos);
                    jttabla.setModel(tabla);

                     int operacion=500/vertic;
                      TableColumn columna = null;
                     for(int i=0;i<vertic;i++)
                    { 
                        if(vertic>7)
                        {
                           columna = jttabla.getColumn("V"+num);
                        }
                        else
                        {
                            columna = jttabla.getColumn("Nombre V"+num);
                        }num++;
                     columna.setMaxWidth(operacion); 
                     jttabla.getColumnModel().getColumn(i).setCellRenderer(jttabla.getTableHeader().getDefaultRenderer());
                    }num=1; 

                    scptabla.setBounds(20, 90,500,38);
                    add(scptabla);
                    
                    Aceptar2 = new JButton("Aceptar");
                    Aceptar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    Aceptar2.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
                    Aceptar2.setFont(new java.awt.Font("Lucida Console", 0, 13));
                    Aceptar2.setBounds(220,140,120,25);
                    add(Aceptar2);
                    ManejadorBoton2 manejador2 = new ManejadorBoton2();
                    Aceptar2.addActionListener( manejador2 );
          }
          else
          {
              JOptionPane.showMessageDialog(MatematicasDiscretas3.this, String.format("No ha ingresado el numero vertices" ) );
          }
       }
    }
    private class ManejadorBoton2 implements ActionListener 
    {    
       public void actionPerformed( ActionEvent evento )
       {  
           if(validacion_noiguales ())
           {
               //System.out.println("Error");
                JOptionPane.showMessageDialog(null,"Error en al rellenar la matriz de nombre","Error",JOptionPane.ERROR_MESSAGE);
           }
           else
           {
                if(entro)
                {
                 scrool.setVisible(false);
                 areaEscribe.setText("");

                }
                 TableModel tableModel = jttabla.getModel();
                 titulo2.setText("Porque vertice comienza el algoritmo");
                 titulo2.setVisible(true);

                 incio.removeAllItems();
                 incio.addItem("SELECCIONE");
                 for(int i=0;i<vertic;i++)
                 {
                     String x=(String) tableModel.getValueAt(0,i);
                    incio.addItem(x);
                 }
                 incio.setBounds(315,180,100,20);
                 add(incio);
                         tablax= new DefaultTableModel();
                         String datos[]=new String [vertic];
                         for(int i=0;i<vertic+1;i++)
                         { 
                            if(i==0)
                            {
                               tablax.addColumn("Vertices"); 
                            }
                            else
                            {

                                 if(vertic>7)
                                 {
                                    tablax.addColumn(tableModel.getValueAt(0,i-1)); 
                                 }
                                 else
                                 {
                                   tablax.addColumn(tableModel.getValueAt(0,i-1)); 
                                 }
                            }
                         }    

                        for (int i = 0; i < vertic; i++)
                        {
                            tablax.addRow(datos);
                        }
                        for (int i = 0; i < vertic; i++)
                        {	
                         tablax.setValueAt(tableModel.getValueAt(0,i), i, 0);
                        }

                        jttabla2.setModel(tablax);
                        numero=20+18*vertic;
                        scptabla2.setBounds(20, 220,500,numero);
                        add(scptabla2);;
                        jttabla2.getColumnModel().getColumn(0).setCellRenderer(jttabla2.getTableHeader().getDefaultRenderer());// Centrar datos de columna 1
                        for(int k=1;k<vertic+1;k++)
                        {
                               TableColumn sportColumn = jttabla2.getColumnModel().getColumn(k);
                               JComboBox comboBox = new JComboBox();  
                                comboBox.addItem("N/C");
                                   for(int i=1;i<=20;i++)
                                   {
                                      comboBox.addItem(i);                                      
                                   }
                                   for(int k2=0;k2<vertic;k2++)
                                   jttabla2.getColumnModel().getColumn(k).setCellRenderer(jttabla2.getTableHeader().getDefaultRenderer());
                               sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
                        }


                        Aceptar3.setBounds(220,numero+235,120,25);
                        Aceptar3.setVisible(true);add(Aceptar3); repaint();
           }
       }
    }
 private class ManejadorBoton3 implements ActionListener 
    {    
       public void actionPerformed( ActionEvent evento )
       { 
           String tem=incio.getSelectedItem().toString();
           if(!"SELECCIONE".equals(tem))
           {
               if(validacion())
               {
                       JOptionPane.showMessageDialog(null,"No ha terminado de rellanar la Matriz de Adyacencia","Error",JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                    
                    areaEscribe.setEditable(false);areaEscribe.setLineWrap(true);areaEscribe.setWrapStyleWord(true);
                    areaEscribe.setFont(new java.awt.Font("Lucida Console", 0, 13));
                              
                    scrool.setBounds(15,numero+235+40, 500, 655-(numero+235+40));
                    add(scrool); scrool.setVisible(true);           
                    entro=true;

                    int [][] dijkstra=new int [vertic][vertic];
                    areaEscribe.setText("1.-Creado Matriz  Dijkstra de longitud: "+vertic+" por "+vertic+"\n");


                    int [] vectoresVisitados= new int[vertic];
                    
                    TableModel tableModel = jttabla.getModel();
                    for(int j=0;j<vertic;j++)
                    {
                          String x=(String) tableModel.getValueAt(0,j);
                          if(incio.getSelectedItem().toString().equals(x))
                          {
                              vectoresVisitados[0]=j;
                          }
                    }
                    areaEscribe.setText(areaEscribe.getText()+"2.-Creado Vector  Visitados de longitud: "+vertic+", en posicion 0 se     ingreso "+(String) tableModel.getValueAt(0,vectoresVisitados[0])+"\n");

                    for(int i=0;i<vertic;i++)
                    {
                        for(int j=0;j<vertic;j++)
                        {
                            dijkstra[i][j]=Integer.MAX_VALUE;
                        }
                    }
                    areaEscribe.setText(areaEscribe.getText()+"3.-Matriz Dijkstra rellanda con infinito \n");
                    
                  
                    TableModel tableModel2 = jttabla2.getModel();
                    for(int i=vectoresVisitados[0];i<=vertic;i++)
                    {
                         for(int j=1;j<=vertic;j++)
                         {
                             String x= tableModel2.getValueAt(i,j).toString();  
                             if(!"N/C".equals(x))
                             {
                                dijkstra[0][j-1]= Integer.parseInt(x);
                             }  
                         }
                         break;
                    }                    
                    for(int i=1;i<vertic;i++)
                    {
                        vectoresVisitados=comparaposmenor(dijkstra,i-1,vectoresVisitados,i);
                        dijkstra=copiaralsig(dijkstra,i);
                        dijkstra=rellenamatrizdijktra(vectoresVisitados,dijkstra,i);                        
                    }
                    
                    tablax2= new DefaultTableModel();
                    String datos[]=new String [vertic];
                    for(int i=0;i<vertic+1;i++)
                    { 
                       if(i==0)
                       {
                          tablax2.addColumn("Iteraciones"); 
                       }
                       else
                       {
                            if(vertic>7)
                            {
                               tablax2.addColumn(tableModel.getValueAt(0,i-1)); 
                            }
                            else
                            {
                              tablax2.addColumn(tableModel.getValueAt(0,i-1)); 
                            }
                       }
                     }  
                    tablax2.addColumn("VA");
                    tablax2.addColumn("S");

                    for (int i = 0; i < vertic; i++)
                    {
                       tablax2.addRow(datos);
                    }
                    for (int i = 0; i < vertic; i++)
                    {	
                     tablax2.setValueAt(i+1, i, 0);
                    }  
                    jttabla3.setModel(tablax2);
                    numero=20+18*vertic;
                    scptabla3.setBounds(535, 90,500,numero);
                    add(scptabla3);
                  
                    for(int i=0;i<=vertic+2;i++)
                    {
                        jttabla3.getColumnModel().getColumn(i).setCellRenderer(jttabla3.getTableHeader().getDefaultRenderer()); // Centrar todas las columnas
                    }                    
                    for(int i=0;i<dijkstra.length;i++)
                    {
                        for(int j=0;j<dijkstra.length;j++)
                        {
                            
                            int x=dijkstra[i][j];
                            if(x==Integer.MAX_VALUE)
                            {
                                tablax2.setValueAt("∞", i,j+1 );
                            }
                            else
                            {
                              tablax2.setValueAt(dijkstra[i][j], i,j+1 );
                            }
                        }
                        
                    }
                    for(int i=0;i<vectoresVisitados.length;i++)
                    {
                        tablax2.setValueAt(tableModel.getValueAt(0,vectoresVisitados[i]), i,vertic+1 );// REELLENA LA COLUMNA CON NOMBRE VA
                    }
                    for(int i=0;i<vectoresVisitados.length;i++)
                    {
                        String x ="";
                        for(int j=0;j<i+1;j++)
                        {                            
                            x=x+tableModel.getValueAt(0,vectoresVisitados[j]).toString()+",";
                        }
                        String cortado=x.substring(0, x.length()-1);
                        tablax2.setValueAt("{ "+cortado+" }", i,vertic+2 );// REELLENA LA COLUMNA CON NOMBRE S                           
                        
                    }
                    //Ajusta ancho de columnas
                    TableColumn columna = jttabla3.getColumn("S");
                    columna.setPreferredWidth(180) ;
                    columna.setMinWidth(70);
                    TableColumn columna2 = jttabla3.getColumn("Iteraciones");
                    columna2.setMinWidth(50);
                    TableColumn columna3 = jttabla3.getColumn("VA");
                    columna3.setMinWidth(30);
               }
           }
           else
           {
               JOptionPane.showMessageDialog(null,"No ha seleccionado donde comienza el algoritmo","Error",JOptionPane.ERROR_MESSAGE);
           }
       }
   }
    boolean validacion()
    {
       TableModel tableModel = jttabla2.getModel(); 
       boolean com=false;
        for(int i=0;i<vertic;i++)
        {
            for(int j=1;j<vertic+1;j++)
            {
                  Object tem= tableModel.getValueAt(i,j);                  
                  if(null==tem)
                  {
                      com=true;
                      break;
                  }
                  else
                  {
                      com=false;
                  }
            }
        }
        return com;
    }
    
    boolean validacion_noiguales ()
    {
        TableModel tableModel = jttabla.getModel(); 
        boolean com=false;
        for(int i=0;i<vertic;i++)
        {
            for(int j=i+1;j<vertic;j++)
            {
                  String x=(String) tableModel.getValueAt(0,i);
                  String x2=(String) tableModel.getValueAt(0,j);
                  x=x.trim();
                  x2=x2.trim();
                  if(x.equals(x2) || x.equals("") || x2.equals("")  )
                  {
                      com=true;
                  }
            }
        }
        return com;
      }
    
    int[][] rellenamatrizdijktra(int vectoresVisitados[], int dijkstra[][] ,int pos)
    {
        boolean pasa=true;
        TableModel tableModel2 = jttabla2.getModel();
        for(int i=vectoresVisitados[pos];i<=vertic;i++)
        {
                    for(int j=1;j<=vertic;j++)
                     {

                         String x= tableModel2.getValueAt(i,j).toString();  

                         if(!"N/C".equals(x))
                         {//////////////////////////CHECAR QUE YA NO ENTRE A SUMAR A POSCIONES DENTRO DEL VETOTESVISITADOS   
                             for(int x2=1;x2<pos;x2++)
                            {
                                if(vectoresVisitados[x2]==j-1)                
                                {
                                    pasa=false;
                                }
                            }                             
                            if(pasa) 
                            {
                                int pos1=vectoresVisitados[pos-1];
                                if(pos1>pos)
                                {
                                    pos1=pos;
                                }
                                int numsuma=dijkstra[pos1][vectoresVisitados[pos]];
                                if(numsuma==2147483647)
                                {
                                    numsuma=dijkstra[i][pos];
                                }
                                
                                    int num=Integer.parseInt(x);
                                    int suma=num+numsuma;
                                    if(dijkstra[pos][j-1]>suma)
                                    {
                                       dijkstra[pos][j-1]= suma;
                                    }
                                
                            }
                            pasa=true;
                         }  
                     }
                     break;
        }
        return dijkstra;
    }
    
    int[] comparaposmenor(int dijkstra[][], int renglon,int vectoresVisitados[],int pos)
    {
        boolean x=true;
        int primernum=Integer.MAX_VALUE;
            for(int j=0;j<vertic;j++)
            {
               
               for(int i=0;i<pos;i++)
               {
                   if(vectoresVisitados[i]==j)                
                   {
                       x=false;
                       break;
                   }
               }
               if(primernum>dijkstra[renglon][j] && x)
               {
                    vectoresVisitados[pos]=j;
                    primernum=dijkstra[renglon][j];
               }
               x=true;
               
            }        
        return vectoresVisitados;
    }
    
     int[][] copiaralsig(int dijkstra[][],int pos)
     {
        for(int i=pos-1;i<vertic;i++)
        {
             for(int j=0;j<vertic;j++)
             {
                 dijkstra[i+1][j]=dijkstra[i][j];
             }
             break;
        }
        
         return dijkstra;
     }
    
    public static void main(String[] args) 
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin ("org.jvnet.substance.skin.BusinessBlackSteelSkin"); 
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceEbonyTheme");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
        MatematicasDiscretas3 p = new MatematicasDiscretas3();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLocation(6,6);
        p.setResizable(false); 
        p.setSize(1050, 700);
        p.setVisible(true);
    }
    
}
