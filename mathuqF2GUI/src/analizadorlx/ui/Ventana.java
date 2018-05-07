package analizadorlx.ui;

import analizadorlx.utilidades.Archivos;
import co.edu.uniquindio.compiladores.frontend.lexico.Analizador;
import co.edu.uniquindio.compiladores.frontend.lexico.Node;
import co.edu.uniquindio.compiladores.frontend.lexico.ParseException;
import co.edu.uniquindio.compiladores.frontend.lexico.SimpleNode;
import co.edu.uniquindio.compiladores.frontend.lexico.TokenMgrError;
import co.edu.uniquindio.compiladores.utils.Impresion;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Ventana del Proyecto Procesadores
 *
 * @author Gustavo Salgado, Jorbe Burbano, Cristian Toro Universidad del Quindio
 * Programa de Ingenieria de Sistemas y Computacion Asignatura: Procesadores
 * @version 1.0
 * @since 2018
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Instancia del controlador de los archivos
     */
    private Archivos archivoManager;

    String tituloVentana = ".:. HUQ - Analizador Semántico .:.";

    //Solo permitir analizar cuando se haya cargado un archivo
    boolean permitirAnalizar = false;

    //Ruta Archivo
    String rutaArchivo = "";

    private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Estructura");

    /**
     * Metodo constructor de la ventana
     */
    public Ventana() {
        initComponents();

        setTitle(tituloVentana);
        setLocationRelativeTo(null);

        archivoManager = new Archivos();
        jTxtAreaConsola.setForeground(Color.blue);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        cEditor = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTxtAreaConsola = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        bNuevo = new javax.swing.JButton();
        bCargar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bGuardarComo = new javax.swing.JButton();
        bCompilar = new javax.swing.JButton();
        bAcerca = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        analizadorlx.utilidades.TextLineNumber tln = new analizadorlx.utilidades.TextLineNumber(cEditor);
        cEditor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(cEditor);
        jScrollPane1.setRowHeaderView( tln );

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setAutoscrolls(true);

        jTxtAreaConsola.setColumns(20);
        jTxtAreaConsola.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTxtAreaConsola.setLineWrap(true);
        jTxtAreaConsola.setRows(5);
        jTxtAreaConsola.setTabSize(2);
        jScrollPane4.setViewportView(jTxtAreaConsola);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Consola");

        arbol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Arbol BNF");
        arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(arbol);

        jToolBar1.setRollover(true);

        bNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/nuevo.png"))); // NOI18N
        bNuevo.setToolTipText("Generar Nuevo Archivo");
        bNuevo.setFocusable(false);
        bNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(bNuevo);

        bCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/abrir.png"))); // NOI18N
        bCargar.setToolTipText("Abrir Archivo");
        bCargar.setFocusable(false);
        bCargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarActionPerformed(evt);
            }
        });
        jToolBar1.add(bCargar);

        bGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/guardar.png"))); // NOI18N
        bGuardar.setToolTipText("Guardar");
        bGuardar.setFocusable(false);
        bGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(bGuardar);

        bGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/guardarcomo.png"))); // NOI18N
        bGuardarComo.setToolTipText("Guardar Como");
        bGuardarComo.setFocusable(false);
        bGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bGuardarComo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarComoActionPerformed(evt);
            }
        });
        jToolBar1.add(bGuardarComo);

        bCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/acerca_devs.png"))); // NOI18N
        bCompilar.setToolTipText("¡Compilar!");
        bCompilar.setFocusable(false);
        bCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCompilarActionPerformed(evt);
            }
        });
        jToolBar1.add(bCompilar);

        bAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/acerca.png"))); // NOI18N
        bAcerca.setToolTipText("Acerca de");
        bAcerca.setFocusable(false);
        bAcerca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAcerca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcercaActionPerformed(evt);
            }
        });
        jToolBar1.add(bAcerca);

        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlx/ui/img/salir.png"))); // NOI18N
        bSalir.setToolTipText("Salir Aplicación");
        bSalir.setFocusable(false);
        bSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(bSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(814, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarActionPerformed
       jTxtAreaConsola.setText("");
cEditor.setText("");
abrirJFileChooser();
    }//GEN-LAST:event_bCargarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
               if (!cEditor.getText().isEmpty()) {
            GuardarJFileChooser(rutaArchivo.isEmpty(), true);
        } else {
            JOptionPane.showMessageDialog(null, "Editor vacio, para guardar un archivo debe escribir codigo!");
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarComoActionPerformed
         GuardarJFileChooser(true, true);
    }//GEN-LAST:event_bGuardarComoActionPerformed

    private void bCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCompilarActionPerformed
       ejecutar();
    }//GEN-LAST:event_bCompilarActionPerformed

    private void bAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcercaActionPerformed
        devsInfo();
    }//GEN-LAST:event_bAcercaActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JButton bAcerca;
    private javax.swing.JButton bCargar;
    private javax.swing.JButton bCompilar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bGuardarComo;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    private javax.swing.JTextPane cEditor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea jTxtAreaConsola;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo Recursivo para llenar Arbol de Derivacion
     *
     * @param raiz Nodo Padre del Jtree
     * @param padre Nodo Inicial que se tomara para construir arbol
     */
    public void generarArbol(DefaultMutableTreeNode raiz, Node padre) {
        for (int i = 0; i < padre.jjtGetNumChildren(); i++) {
            Node nuevoPadre = padre.jjtGetChild(i);
            String finales = nuevoPadre.toString();
            if (nuevoPadre.jjtGetNumChildren() == 0) {
                finales += "(" + ((SimpleNode) nuevoPadre).jjtGetValue().toString() + ")";
            }
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(finales);
            generarArbol(nodo, nuevoPadre);
            raiz.add(nodo);
        }
    }

    /**
     * Ejecutar Analizador Sintactico
     */
    private void ejecutar() {
        if (permitirAnalizar) {
            try {
                GuardarJFileChooser(false, false);

                //Borrar consola cuando se inicia el analisis
                jTxtAreaConsola.setText("");

                Analizador sintacticoA = new Analizador(new java.io.FileInputStream(rutaArchivo));
                sintacticoA.init();
                //sintacticoA.obtenerListadoTokens();

                sintacticoA.ReInit(new java.io.FileInputStream(rutaArchivo));
                SimpleNode nodo = sintacticoA.mathuq();
                System.out.println("anal.getErrores().size() " + sintacticoA.getErrores().size());

                if (sintacticoA.getErrores().isEmpty()) {
                    System.out.println("Nodo Principal  " + nodo);
                    System.out.println("Nodo Hijos " + nodo.jjtGetNumChildren());

                    raiz = new DefaultMutableTreeNode("Estructura");
                    generarArbol(raiz, nodo);
                    DefaultTreeModel modelo = new DefaultTreeModel(raiz);
                    arbol.setModel(modelo);
                    colorConsola(Color.BLUE);
                    String consola = "Analisis Sintáctico realizado con exito.";
                    jTxtAreaConsola.setText(consola);
                } else {
                    colorConsola(Color.RED);
                    String consola = Impresion.imprimirErrores(sintacticoA.getErrores());
                    jTxtAreaConsola.setText(consola);

                    DefaultMutableTreeNode raizError = new DefaultMutableTreeNode("No Arbol");
                    DefaultTreeModel modelo = new DefaultTreeModel(raizError);
                    arbol.setModel(modelo);
                }
            } catch (TokenMgrError te) {
                System.out.println("GUI - Se han encontrado errores lexicos.");
                System.out.println(te.getMessage());
                jTxtAreaConsola.setText("Errores Lexicos Encontrados, para poder analizar sintacticamente debe corregirlos primero.\n" + te.getMessage());
            } catch (ParseException e) {
                System.out.println("Analizador: Se han encontrado errores en Parse.");
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Upps!, Error Sintactico no controlado. Por favor reinicie la aplicacion e intente nuevamente con otro archivo.");
                jTxtAreaConsola.setText(e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("Analizador: Error General");
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "No se encuentra el Archivo, por favor revise las rutas:\n" + e.getMessage());
            }

        } else {
            String msj= "Para realizar un análisis Sintáctico\nse requiere cargar un archivo válido.\nPor favor abra un Archivo .huq o cree un nuevo archivo.";
            
            if ( rutaArchivo.isEmpty() && !cEditor.getText().isEmpty()){
                msj = "Para ejecutar analisis primero debe guardar el archivo.";
            }                     
            
            JOptionPane.showMessageDialog(null, msj);
        }

    }

    /**
     * Abre el archivo deseado
     */
    private void abrirJFileChooser() {
        JFileChooser fileChoser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".huq", "HUQ", "*.huq");
        fileChoser.setFileFilter(filtro);
        fileChoser.showOpenDialog(this);

        File archivo = fileChoser.getSelectedFile();

        if (null != archivo) {

            String contenido = archivoManager.leerArchivo(archivo);

            if (null != contenido) {
                permitirAnalizar = true;
                actualizarRutasArchivo(archivo);
                cEditor.setText(contenido);
            }
        } else {
            permitirAnalizar = false;
        }
    }

    /**
     * Guarda el archivo deseado
     *
     * @param guardarComo identifica si es un guardar o guardarComo
     */
    private boolean GuardarJFileChooser(boolean guardarComo, boolean callback) {
        boolean ban = false;
        boolean guarda = false;       
        
        if (guardarComo) {
            JFileChooser fileChoser = new JFileChooser();
            fileChoser.setSelectedFile(new File("miMarthUQ_" + System.currentTimeMillis() + ".huq"));
            fileChoser.setFileFilter(new FileNameExtensionFilter(".huq", "huq"));
            fileChoser.showSaveDialog(this);
            File nuevoArchivo = fileChoser.getSelectedFile();

            if (null != nuevoArchivo) {
                //guardarComo....
                guarda = archivoManager.guardar(cEditor.getText(), nuevoArchivo);
                actualizarRutasArchivo(nuevoArchivo);

                if (guarda) {
                    if (callback) {
                        JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no pudo guardarse");
                }
            }
            ban = true;
        } else {
            guarda = archivoManager.guardar(cEditor.getText(), new File(rutaArchivo));
            if (guarda) {
                if (callback) {
                    JOptionPane.showMessageDialog(null, "Archivo guardado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no pudo guardarse.");
            }
            ban = true;
        }
        return ban;
    }

    /**
     * Actualiza la ruta del archivo analizado
     *
     * @param archivo el archivo a actualizar
     */
    private void actualizarRutasArchivo(File archivo) {
        try {
            setTitle(tituloVentana + " | analizando : " + archivo.getCanonicalPath());
            rutaArchivo = archivo.getCanonicalPath();
            
            //Permite Analizar si actualiza las rutas
            permitirAnalizar = true;

        } catch (IOException ex) {
            Logger.getLogger(Ventana.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Informacion sobre los colaboradores del proyecto
     */
    private void devsInfo() {
        JOptionPane.showMessageDialog(null, "Fase III: Compilador\n"
                + "Universidad del Quindio 2018\n"
                + "Grupo:\n"
                + "Jorge Burbano - Cristian Toro - Gustavo Salgado");
    }

    /**
     * Cambiar Color Consola
     *
     * @param color Constante que representa el Color
     */
    private void colorConsola(Color color) {
        jTxtAreaConsola.setForeground(color);
    }

    /**
     * Reiniciar Ventana
     */
    private void nuevo() {
        DefaultMutableTreeNode raizError = new DefaultMutableTreeNode("No Arbol");
        DefaultTreeModel modelo = new DefaultTreeModel(raizError);
        arbol.setModel(modelo);
        
        cEditor.setText("");
        jTxtAreaConsola.setText("");
        
        rutaArchivo = "";
        
        permitirAnalizar = false;
    }

}
