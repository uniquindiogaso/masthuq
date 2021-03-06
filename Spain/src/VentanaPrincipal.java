import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Element;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.omg.Messaging.SyncScopeHelper;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.security.auth.callback.TextOutputCallback;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame  {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JPanel panelArbol;
	private static JTextArea jTAEditor;
	private JTextArea jTAErrores;
	//private JPanel jTAArbol;
	int contador=0;
	private String textoactual="";
	private String ruta="";
	private JMenuItem mntmGuardar;
	JTree arbol;/*declaramos el objeto Arbol*/
	JScrollPane scrollPaneArbol,scrollPaneArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblAreaDeAnalisis =   new JLabel("Area de analisis");
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		     arbol = new JTree();
	        
	        //llamamos el metodo que permite la creaci�n del Arbol
	       //  crearArbol();
	        
	        
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 837, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setBackground(Color.WHITE);
		menuBar.add(mnArchivo);
	
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setBackground(Color.GRAY);
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ruta al abrir " +ruta);
				mntmGuardar.setVisible(true);
				String aux="";
				String texto="";
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filtroext = new FileNameExtensionFilter(".huq", "huq");
				fc.setFileFilter(filtroext);
				int respuesta = fc.showOpenDialog(fc);
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					File archivoElegido = fc.getSelectedFile();
					try {
						FileReader fr= new FileReader(archivoElegido);
						BufferedReader br= new BufferedReader(fr);
						while((aux=br.readLine())!=null){
							texto+=aux+"\n";
						}
						br.close();
						jTAEditor.setText(texto);
						textoactual=texto;
						lblAreaDeAnalisis.setVisible(false);
						jTAErrores.setText("");
						//jTAArbol.repaint();
						if (ruta.isEmpty()) {
							ruta = archivoElegido.getCanonicalPath()+".huq";
						}
						
						System.out.println("desde el abrir"+ruta);
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "El archivo no se encuentra en el directorio");
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
					}
					
				}
				
				
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mntmNuevo_1.setBackground(Color.GRAY);
		mntmNuevo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 mntmGuardar.setVisible(false);
				
				jTAEditor.setText("");
				//jTAArbol.repaint();
				jTAErrores.setText(" ");
			    
			
				String ruta = System.getProperty("user.home")+"\\temp.huq";//"C:\\Users\\qbex\\Documents\\.huq";
				System.out.println("Ruta default " + ruta);
		        File archivo = new File(ruta);
		        BufferedWriter bw = null;
		        if(archivo.exists()) {
		            try {
						bw = new BufferedWriter(new FileWriter(archivo));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
						
						e.printStackTrace();
					}
		            try {
		            	JOptionPane.showMessageDialog(null,"El fichero ya esta creado");
		            	
						bw.write("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("entro 2");
						e.printStackTrace();
					}
		        } else {
		            try {
						bw = new BufferedWriter(new FileWriter(archivo));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
						e.printStackTrace();
					}
		            try {
		            	
						bw.write("");
						
						JOptionPane.showMessageDialog(null,"Tienes un archivo nuevo");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
				
			}
		});
		mnArchivo.add(mntmNuevo_1);
		
		 mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setBackground(Color.GRAY);
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		

				  guardar();
				
	}
			
		});
		mnArchivo.add(mntmGuardar);
		
		
		

		
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.setBackground(Color.GRAY);
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmGuardar.setVisible(true);
				
					
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Guardar Archivo");
					FileNameExtensionFilter filtroext = new FileNameExtensionFilter(".huq", "huq");
					fc.setFileFilter(filtroext);
					int respuesta = fc.showSaveDialog(fc);
					if (respuesta == JFileChooser.APPROVE_OPTION) {
						try {
							FileWriter fw;
//							if(fc.getSelectedFile().getAbsolutePath().contains(".huq")){
//								fw=  new FileWriter(fc.getSelectedFile());
//								ruta = fc.getSelectedFile().getCanonicalPath();
//							}else{
//								fw=  new FileWriter(fc.getSelectedFile());
//								ruta = fc.getSelectedFile().getCanonicalPath();
//							}
							fw=  new FileWriter(fc.getSelectedFile()+".huq");
							ruta = fc.getSelectedFile().getCanonicalPath()+".huq";
							
							BufferedWriter br = new BufferedWriter(fw); 
							br.write(jTAEditor.getText()); 
							br.close();
							textoactual=jTAEditor.getText();
							lblAreaDeAnalisis.setVisible(false);
							JOptionPane.showMessageDialog(null, "El archivo se a guardado correctamente");							
							System.out.println(ruta);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "El archivo no ha sido guardado debido a un error");
						}
					}
				}
		});
		mnArchivo.add(mntmGuardarComo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.setBackground(Color.GRAY);
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit( 0 ); 
			}
		});
		mnArchivo.add(mntmCerrar);
		
		JMenu mnCompilar = new JMenu("Compilar");
		mnCompilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comp analizador= new comp();
				 String cadena= jTAEditor.getText();
				 InputStream stream= new ByteArrayInputStream(cadena.getBytes(StandardCharsets.UTF_8));
					if(contador==0){
						contador++;
						analizador= new comp(stream);
						analizador.setError(" ");
					}else{
						//analizador.LimpiarErrores("");
						//analizador.reInitErrores();
						panelArbol.repaint();
						jTAErrores.setText(" ");
						analizador.setError(" ");
						analizador.ReInit(stream);
						
					}
					try{
						SimpleNode var = analizador.Programa();
						//jTAArbol.setText(var.dump(""));
						jTAErrores.setText(analizador.acumuladorErrores+"\n Se ha compilado con exito el programa.");
					    System.out.println(analizador.acumuladorErrores);
					    
					    var.dump(""); 
					    String obtener[] = var.toString().split("\n");
					    
					    
					    for(int i=0;i<obtener.length;i++){
					    	System.out.println(obtener[i]);
					    	
					    }
					   
					    
					    
					    //crearArbol();
					   CrearArbolSintactico(obtener);
					  //agrego arbol al panel
					    
						 scrollPaneArbol.setViewportView(arbol);
					     panelArbol.add(scrollPaneArbol);
					     //panelArbol.repaint();
					     repaint();
					    // contentPane.add(panelArbol);
						
					}catch(TokenMgrError te)
					{
						String error="Error\n"+te.getMessage();
					jTAErrores.setText(error);

					}
					catch(ParseException ex)
					{
						String error="Analizador: Se han encontrado errores en el analisis.\n"+ex.getMessage();
						jTAErrores.setText(error);
					}
			}
		});
		menuBar.add(mnCompilar);
		
		JPanel panelEditor = new JPanel();
		panelEditor.setBackground(new Color(169, 169, 169));
		panelEditor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Editor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panelEditor.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		panelEditor.setBounds(10, 32, 384, 339);
		contentPane.add(panelEditor);
		KeyListener keyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(textoactual.equals(jTAEditor.getText())){
					 lblAreaDeAnalisis.setVisible(false);
				}else{
					 lblAreaDeAnalisis.setVisible(true);
				}
			}
		};
		panelEditor.setLayout(null);
		jTAEditor= new JTextArea();
		jTAEditor.addKeyListener(keyListener);
		JScrollPane scroll;
		scroll_1= new JScrollPane(jTAEditor);
		scroll_1.setSize(364, 318);
		scroll_1.setLocation(10, 20);
		scroll= createGUI(scroll_1);
		scroll.setBounds(10, 21, 365, 320);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelEditor.add(scroll);
		
		JPanel panelErrores = new JPanel();
		panelErrores.setBorder(new LineBorder(SystemColor.activeCaption));
		panelErrores.setBounds(10, 408, 817, 136);
		contentPane.add(panelErrores);
		panelErrores.setLayout(null);
		jTAErrores= new JTextArea();
		jTAErrores.setBackground(new Color(211, 211, 211));
		JScrollPane scrollErrores= new JScrollPane(jTAErrores);
		scrollErrores.setLocation(10, 11);
		scrollErrores.setSize(797, 114);
		panelErrores.add(scrollErrores);
		
		panelArbol = new JPanel();
		panelArbol.setBorder(new TitledBorder(null, "\u00C1rbol de derivacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelArbol.setBounds(404, 32, 413, 339);
		contentPane.add(panelArbol);
		panelArbol.setLayout(null);
	
		scrollPaneArbol = new JScrollPane();
        scrollPaneArbol.setBounds(0,20,413,310);
	
		
        //agrego arbol al panel
	     //scrollPaneArbol.setViewportView(arbol);
	     //panelArbol.add(scrollPaneArbol);
		
		
		lblAreaDeAnalisis.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblAreaDeAnalisis.setForeground(Color.RED);
		lblAreaDeAnalisis.setBounds(376, 382, 152, 21);
		contentPane.add(lblAreaDeAnalisis);
	}
	
	private static JTextArea lines;
	private JScrollPane scroll_1;
	public static JScrollPane createGUI(JScrollPane scroll){
		lines = new JTextArea("1");
 
		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);
 
		jTAEditor.getDocument().addDocumentListener(new DocumentListener(){
			public String getText(){
				int caretPosition = jTAEditor.getDocument().getLength();
				Element root = jTAEditor.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");
				for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
					text += i + System.getProperty("line.separator");
				}
				return text;
			}
			@Override
			public void changedUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
			@Override
			public void insertUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
			@Override
			public void removeUpdate(DocumentEvent de) {
				lines.setText(getText());
			}
 
		});
		scroll.setViewportView(jTAEditor);
		scroll.setRowHeaderView(lines);
 
		return scroll;
	}
	
	public void guardar() {
		System.out.println("Ruta desde el guardar .... "+ruta);
		try {
			
			FileWriter fw = new FileWriter(new File(ruta));
			BufferedWriter br = new BufferedWriter(fw); 
			br.write(jTAEditor.getText()); 
			br.close();
			textoactual=jTAEditor.getText();
			JOptionPane.showMessageDialog(null, "El archivo se a guardado correctamente");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Primero debe guardar`como` el archivo para luego guardar cambios");
		}
	}
	
	
		
		
		private void CrearArbolSintactico(String[] obtener){
		
			
			 DefaultTreeModel modelo = null;
			 
			 DefaultMutableTreeNode carpetaRaiz = new DefaultMutableTreeNode(obtener[0]);
	         modelo = new DefaultTreeModel(carpetaRaiz);
	         int incre=0;
	         int incre2=0;
	         DefaultMutableTreeNode carpeta2 = new DefaultMutableTreeNode(obtener[1]);  		
	        
	      	   modelo.insertNodeInto(carpeta2, carpetaRaiz,incre2);
	      	 	
	      	 DefaultMutableTreeNode hoja=null;
		        DefaultMutableTreeNode aux;
		        aux=carpetaRaiz;
	        for(int i=1;i<obtener.length;i++){
	        	
	        	if(!obtener[i].contains("PUNTO (.)")){
	        		 hoja = new DefaultMutableTreeNode(obtener[i]);  			
	        		  modelo.insertNodeInto(hoja, carpeta2,incre);
	        		  incre++;
	        	}else{
	        	hoja = new DefaultMutableTreeNode(obtener[i]);
	        	 modelo.insertNodeInto(hoja, carpeta2,incre);
	        	carpeta2 = new DefaultMutableTreeNode(obtener[i+1]);
	        	incre=0;
	        	incre2++;
	      	   modelo.insertNodeInto(carpeta2, carpetaRaiz,incre2);
	        	
	        	}
	        	
	        		
	        	
	        	
	        		
	        }
	        
	        arbol = new JTree(modelo);
			
		}
		
	
}
