/****************
 * This code was automatically generated by lwm2m_codegen.
 ****************/
package org.eclipse.leshan.client.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import org.eclipse.leshan.client.servers.ServerIdentity;
import org.eclipse.leshan.client.resource.BaseInstanceEnabler;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.node.LwM2mResource;
import org.eclipse.leshan.core.request.argument.Arguments;
import org.eclipse.leshan.core.response.ExecuteResponse;
import org.eclipse.leshan.core.response.ReadResponse;
import org.eclipse.leshan.core.response.WriteResponse;
import org.eclipse.leshan.core.util.NamedThreadFactory;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.EventQueue;

public class Luminaire extends BaseInstanceEnabler {
    static final int OBJECT_ID_LUMINAIRE = 33001;
    static final int OBJECT_ID = 33001;
    // Static values for resource items
    private static final int RES_POWER = 30000;
    private static final int RES_TYPE = 30002;
    private static final int RES_PEAK_POWER = 30003;
    private static final int RES_DIM_LEVEL = 30004;
    private static final List<Integer> supportedResources =
     Arrays.asList(
             RES_POWER
           , RES_TYPE
           , RES_PEAK_POWER
           , RES_DIM_LEVEL
           );
    // Variables storing current values.

    private boolean vPower = false;
   private JLabel glPower;
   private JLabel gvPower;
   private JTextField tfPower;

  // LED, Halogen
    private String vType = "";
   private JLabel glType;
   private JLabel gvType;
   private JComboBox cbType;
   private String[] cbvType = { "LED", "Halogen" };

    private long vPeakPower = 0;
   private JLabel glPeakPower;
   private JLabel gvPeakPower;
   private JTextField tfPeakPower;

  // 0..100
    private long vDimLevel = 0;
   private JLabel glDimLevel;
   private JLabel gvDimLevel;
   private JTextField tfDimLevel;
   private JFrame guiFrame;

  public Luminaire() {
      //  Automatically generated GUI code.
    guiFrame = new JFrame();
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    guiFrame.setTitle("Luminaire");

  // Power
    glPower = new JLabel();
    glPower.setText("Power");
    gvPower = new JLabel();
    gvPower.setText(Boolean.toString(vPower));
    tfPower = new JTextField();
    tfPower.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfPower.getText();
           setPower(Boolean.valueOf(sValue));
       }
     });

  // Type
    glType = new JLabel();
    glType.setText("Type");
    gvType = new JLabel();
    gvType.setText(vType);
    cbType = new JComboBox(cbvType);
    cbType.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)cbType.getSelectedItem();
           setType(String.valueOf(sValue));
       }
     });

  // Peak power
    glPeakPower = new JLabel();
    glPeakPower.setText("Peak power");
    gvPeakPower = new JLabel();
    gvPeakPower.setText(Long.toString(vPeakPower));
    tfPeakPower = new JTextField();
    tfPeakPower.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfPeakPower.getText();
           setPeakPower(Integer.valueOf(sValue));
       }
     });

  // Dim Level
    glDimLevel = new JLabel();
    glDimLevel.setText("Dim Level");
    gvDimLevel = new JLabel();
    gvDimLevel.setText(Long.toString(vDimLevel));
    tfDimLevel = new JTextField();
    tfDimLevel.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfDimLevel.getText();
           setDimLevel(Integer.valueOf(sValue));
       }
     });

  // Create layout of labels, inputs and values.
   GridLayout layout = new GridLayout(0,3,10,10);
   guiFrame.getContentPane().setLayout(layout);
   Container guiPane = guiFrame.getContentPane();
   guiPane.add(glPower);
   guiPane.add(tfPower);
    guiPane.add(gvPower);
   guiPane.add(glType);
   guiPane.add(cbType);
    guiPane.add(gvType);
   guiPane.add(glPeakPower);
   guiPane.add(tfPeakPower);
    guiPane.add(gvPeakPower);
   guiPane.add(glDimLevel);
   guiPane.add(tfDimLevel);
    guiPane.add(gvDimLevel);
  guiFrame.pack();
  // Code to make the frame visible.
  java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
         guiFrame.setVisible(true);
      }
    });
  }

  @Override
  public synchronized ReadResponse read(ServerIdentity identity, int resourceId) {
    switch (resourceId) {
    case RES_POWER:
         return ReadResponse.success(resourceId, vPower);
    case RES_TYPE:
         return ReadResponse.success(resourceId, vType);
    case RES_PEAK_POWER:
         return ReadResponse.success(resourceId, vPeakPower);
    case RES_DIM_LEVEL:
         return ReadResponse.success(resourceId, vDimLevel);
    default:
      return super.read(identity, resourceId);
    }
  }

  @Override
  public WriteResponse write(ServerIdentity identity, boolean replace, int resourceId, LwM2mResource value) {
    switch (resourceId) {
    case RES_POWER:
        // vPower = (Boolean) value.getValue();
        // fireResourceChange(resourceId);
        setPower((Boolean) value.getValue());
        return WriteResponse.success();
    case RES_DIM_LEVEL:
        // vDimLevel = (Integer) value.getValue();
        // fireResourceChange(resourceId);
        setDimLevel((Long) value.getValue());
        return WriteResponse.success();
    default:
      return super.write(identity, replace, resourceId,value);
    }
  }

  @Override
  public synchronized ExecuteResponse execute(ServerIdentity identity, int resourceId, Arguments arguments) {
    switch (resourceId) {
    default:
      return super.execute(identity, resourceId,arguments);
    }
  }

  @Override
  public List<Integer> getAvailableResourceIds(ObjectModel model) {
     return supportedResources;
  }

    // Configure before registration, don't fire.
    public void configure(String lumtype, long peakpower) {
	vType = lumtype;
	gvType.setText(lumtype);
	vPeakPower = peakpower;
	gvPeakPower.setText(Long.toString(vPeakPower));
    }
    
  private synchronized void setPower(boolean value) {
    if (vPower != value) {
       vPower = value;
 gvPower.setText(Boolean.toString(vPower));
       fireResourceChange(RES_POWER);
    }
  }

  private synchronized void setType(String value) {
    if (vType != value) {
       vType = value;
 gvType.setText(vType);
       fireResourceChange(RES_TYPE);
    }
  }

  private synchronized void setPeakPower(long value) {
    if (vPeakPower != value) {
       vPeakPower = value;
 gvPeakPower.setText(Long.toString(vPeakPower));
       fireResourceChange(RES_PEAK_POWER);
    }
  }

  private synchronized void setDimLevel(long value) {
    if (vDimLevel != value) {
       vDimLevel = value;
 gvDimLevel.setText(Long.toString(vDimLevel));
       fireResourceChange(RES_DIM_LEVEL);
    }
  }

}
