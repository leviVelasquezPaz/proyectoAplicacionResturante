/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import rojerusan.RSPanelImage;

/**
 *
 * @author Antonio AB
 */
public abstract class CargarIamgenCategoria {

    private BufferedImage imagen = null;
    private FileNameExtensionFilter importar = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "png");
    private URL obtener;

    public CargarIamgenCategoria() {

    }

    public void cargarImagen(URL url) {
        try {
            imagen = ImageIO.read(url);

        } catch (Exception e) {
            Logger.getLogger(CargarIamgenCategoria.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public BufferedImage obtenerImagenBuffered() {
        return imagen;
    }

    public void abrirPaneldeImagen(JPanel p) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(importar);
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                setObtener(fileChooser.getSelectedFile().toURL());
                URL url = fileChooser.getSelectedFile().toURL();
                cargarImagen(url);
                p.add(new PanelAdicionCargar(obtenerImagenBuffered(), p.getSize()) {
                });
                p.setVisible(true);
                p.repaint();

            } catch (Exception e) {
                Logger.getLogger(CargarIamgenCategoria.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    public void mostrar(RSPanelImage p) {
        try {
            URL url=getObtener();
            cargarImagen(url);
            p.add(new PanelAdicionCargar(obtenerImagenBuffered(), p.getSize()) {
            });
            p.setVisible(true);
            p.repaint();
        } catch (Exception e) {
                        Logger.getLogger(CargarIamgenCategoria.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public String ObtnerURL() {
        return " " + getObtener() + " ";
    }

    public URL getObtener() {
        return obtener;
    }

    public void setObtener(URL obtener) {
        this.obtener = obtener;
    }

}
