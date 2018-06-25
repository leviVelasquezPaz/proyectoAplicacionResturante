/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import rojerusan.RSPanelImage;

/**
 *
 * @author Antonio AB
 */
public abstract class PanelAdicionCargar extends javax.swing.JPanel{
 BufferedImage _image;
    /* coloca la imagen que se encuentra en el Buffer en el objeto JPanel
     * redimensiona la imagen para que encaje en las dimensiones del Jpanel
     * pero la imagen que se encuentra en el Buffer, preserva el tamaÃ±o original
     */

    public PanelAdicionCargar(BufferedImage imagen, Dimension d) {
        this._image = imagen;
        this.setSize(d);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon(_image);
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);
   
        setOpaque(false);
        super.paintComponent(g);
    }
}
