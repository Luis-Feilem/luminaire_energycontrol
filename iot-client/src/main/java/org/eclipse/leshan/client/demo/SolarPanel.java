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

public class SolarPanel extends BaseInstanceEnabler {
    static final int OBJECT_ID_SOLAR_PANEL = 33004;
    static final int OBJECT_ID = 33004;
    // Static values for resource items
    private static final int RES_AVAILABLE_ENERGY = 30011;
    private static final List<Integer> supportedResources =
     Arrays.asList(
             RES_AVAILABLE_ENERGY
           );
    // Variables storing current values.

    private long vAvailableEnergy = 0;
   private JLabel glAvailableEnergy;
   private JLabel gvAvailableEnergy;
   private JTextField tfAvailableEnergy;
   private JFrame guiFrame;

  public SolarPanel() {
      //  Automatically generated GUI code.
    guiFrame = new JFrame();
    guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    guiFrame.setTitle("Solar Panel");

  // Available energy
    glAvailableEnergy = new JLabel();
    glAvailableEnergy.setText("Available energy");
    gvAvailableEnergy = new JLabel();
    gvAvailableEnergy.setText("");
    tfAvailableEnergy = new JTextField();
    tfAvailableEnergy.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String sValue = (String)tfAvailableEnergy.getText();
           setAvailableEnergy(Long.valueOf(sValue));
       }
     });

  // Create layout of labels, inputs and values.
   GridLayout layout = new GridLayout(0,3,10,10);
   guiFrame.getContentPane().setLayout(layout);
   Container guiPane = guiFrame.getContentPane();
   guiPane.add(glAvailableEnergy);
   guiPane.add(tfAvailableEnergy);
    guiPane.add(gvAvailableEnergy);
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
    case RES_AVAILABLE_ENERGY:
         return ReadResponse.success(resourceId, vAvailableEnergy);
    default:
      return super.read(identity, resourceId);
    }
  }

  @Override
  public WriteResponse write(ServerIdentity identity, boolean replace, int resourceId, LwM2mResource value) {
    switch (resourceId) {
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

  private synchronized void setAvailableEnergy(long value) {
    if (vAvailableEnergy != value) {
       vAvailableEnergy = value;
 gvAvailableEnergy.setText(Long.toString(vAvailableEnergy));
       fireResourceChange(RES_AVAILABLE_ENERGY);
    }
  }

}
