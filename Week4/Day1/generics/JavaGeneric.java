/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Manasvi
 */
public class JavaGeneric {
    
    
    public static class Extras<T>{
        //specific to eyes
        
        //****not compulsory
        boolean belongsToEachEye;//true -- each eye
        T eyesOuter = null;  
        //****
        
        Vector<T> eyes = new Vector();   //vector of eyes
        
        //specific to mouth
        T mouthOuter = null;
        
        //****not compulsory
        T[] teeth = null;        
        //****
    }
    
    
    public static class Shapes{
        String shapeName=null;    //all shapes    
        String borderColor=null; //all shapes       
        String filledColor=null;  //all shapes      
        boolean pointAtTop; //specific to triangle       
        boolean equalSides;  //true -- square, false -- rectangle      
        boolean size; // true -- large , false -- small
        
        
        Extras others=null;
    
    
    }
    

    
    public static class HauntedFaces<T>{
        
        ArrayList<T> list = new ArrayList();       
     
        public void inner(Shapes inner){            
                                             
            Iterator draw =  inner.others.eyes.iterator();


            
            int i = 0;            
            while(draw.hasNext()){                                               
                if(inner.others.eyesOuter!=null){
                   if(inner.others.belongsToEachEye){
                       System.out.println("To border a eye ... ");
                       outlineShape((Shapes)inner.others.eyesOuter);
                   }
                   else if(i==0){
                       System.out.println("To Border both eyes ... ");
                       outlineShape((Shapes)inner.others.eyesOuter);
                   }                   
                }                
                Shapes eye = (Shapes)draw.next();
                if(i==0){
                    drawEye(eye,"Left");
                }else{
                    drawEye(eye,"Right");
                }                
                i++;
            }

            drawMouth((Shapes)inner.others.mouthOuter);                    
            
            
            if(inner.others.teeth!=null){
                drawTeeth((Shapes[]) inner.others.teeth);                    
            }
            
                                    
                                                          
        }        
        
        
        
        
        
        public void fillColor(Shapes shape){
            
            if(shape.filledColor!=null){
                System.out.println("Fill it with "+shape.filledColor+" color");
            }
                              
        }
        
        
        public void drawCircle(Shapes circle){
            
            if(circle.size){                
                System.out.println("Draw A "+sizeCheck(circle)+" "+circle.borderColor+" Circle");            
                fillColor(circle);
            }else{
                System.out.println("Draw A "+sizeCheck(circle)+" "+circle.borderColor+" Circle");
                fillColor(circle);
            }
            
        }
        
        public String sizeCheck(Shapes shape){
            
            if(shape.size){
                return "Large";
            }else{
                return "Small";
            }
            
        }
        
        public void drawBox(Shapes box){
        
            if(box.equalSides){
                System.out.println("Draw A "+sizeCheck(box)+" "+box.borderColor+" Square");                    
                            
                fillColor(box);
            }else{
                System.out.println("Draw A "+sizeCheck(box)+" "+box.borderColor+" Rectangle");
                fillColor(box);
            }
            
        }
        
        public void drawTriangle(Shapes triangle){
            if(triangle.pointAtTop){                
                System.out.println("Draw A "+sizeCheck(triangle)+" "+triangle.borderColor+" Triangle Pointed Upwards");            
                fillColor(triangle);
            }else{
                System.out.println("Draw A "+sizeCheck(triangle)+" "+triangle.borderColor+" Triangle Pointed Downwards");
                fillColor(triangle);
            }                                   
        }
        
        public void outlineShape(Shapes shape){
            if("Triangle".equals(shape.shapeName)){
                drawTriangle(shape);
            }else if("Circle".equals(shape.shapeName)){
                drawCircle(shape);
            }else{
                drawBox(shape);
            }
            
        }
        
        

        

        public void drawFace(Shapes face){
            System.out.println("For face first ... ");
            outlineShape(face);                        
        }
        public void drawEye(Shapes eye, String position){
            
            if("Left".equals(position)){
            
                System.out.println("For left eye ... ");
                outlineShape(eye);
            
            }else{
            
                System.out.println("For right eye ... ");
                outlineShape(eye);
            
            }
            
        }
        public void drawMouth(Shapes mouth){                       
            System.out.println("For mouth ... ");
            outlineShape(mouth);                                     
        }        
        public void drawTeeth(Shapes teeth[]){
            System.out.println("Follow these continously ... ");
            for(int i = 0; i<teeth.length;i++){
                outlineShape(teeth[i]);
            }
        }
        
        
        
    }
    
    
    
    public static void main(String []args){
        
        HauntedFaces<Shapes> faces =  new HauntedFaces();
        
        Shapes s1 = new Shapes();
        s1.shapeName = "Circle";
        s1.borderColor = "Purple";
        s1.size= true;                
        s1.others = new Extras<Shapes>();
        
        Shapes e1 = new Shapes();
        e1.shapeName = "Box";
        e1.borderColor = "Green";
        
        Shapes e2 = new Shapes();
        e2.shapeName = "Box";
        e2.borderColor = "Green";        
        e2.equalSides = true;
        
        s1.others.eyes.add(e1);
        s1.others.eyes.add(e2);
        
        
        Shapes m = new Shapes();
        m.shapeName="Triangle";
        m.borderColor="Pink";
        
        s1.others.mouthOuter = m;        

        
        faces.list.add(s1);
        
        
        
        
//        faces.drawFace(faces.list.get(0));
//        faces.inner(faces.list.get(0));
               
        
        System.out.println("----------------------------------------------------------------------------");
        
        Shapes s2 = new Shapes();
        s2.shapeName = "Circle";
        s2.borderColor = "Blue";
        s2.size= true;                
        s2.others = new Extras<Shapes>();
        
        Shapes s2e1 = new Shapes();
        s2e1.shapeName = "Triangle";
        s2e1.borderColor = "Purple";
        
        Shapes s2e2 = new Shapes();
        s2e2.shapeName = "Triangle";
        s2e2.borderColor = "Purple";        
        s2e2.filledColor = "Black";
        
        s2.others.eyes.add(s2e1);
        s2.others.eyes.add(s2e2);
        
        
        Shapes s2m = new Shapes();
        s2m.shapeName="Triangle";
        s2m.borderColor="Pink";
        s2m.pointAtTop = true;
        s2.others.mouthOuter = s2m;        

        
        faces.list.add(s2);
        
        
//        faces.drawFace(faces.list.get(1));
//        faces.inner(faces.list.get(1));
               
        
        System.out.println("----------------------------------------------------------------------------");
        
        
        
              
        
        
        
        Shapes s3 = new Shapes();
        s3.shapeName = "Circle";
        s3.borderColor = "Green";
        s3.size = true;
        
        s3.others = new Extras<Shapes>();
        
        s3.others.belongsToEachEye = true;
        
        Shapes s3eyeOut = new Shapes();        
        s3eyeOut.borderColor = "Black";
        s3eyeOut.shapeName = "Box";
        s3eyeOut.equalSides=true;
        
        s3.others.eyesOuter = s3eyeOut;
        
        
        
        
        
        Shapes s3eye1= new Shapes();
        s3eye1.borderColor = "Red";
        s3eye1.shapeName = "Circle";
        
        Shapes s3eye2= s3eye1;// reference 
        
        
        s3.others.eyes.add(s3eye1);
        s3.others.eyes.add(s3eye2);
        
        Shapes s3mouth = new Shapes();
        s3mouth.borderColor = "Pink";
        s3mouth.shapeName = "Box";               
        s3.others.mouthOuter = s3mouth;
        
        
        Shapes s3Teeth = new Shapes();
        s3Teeth.borderColor = "Green";
        s3Teeth.shapeName = "Triangle";
        s3Teeth.pointAtTop = true;
        
        
        s3.others.teeth = new Shapes[3];
        
        
        Arrays.fill(s3.others.teeth, s3Teeth);        
        
        faces.list.add(s3);        
//        faces.drawFace(faces.list.get(2));
//        faces.inner(faces.list.get(2));
        
        System.out.println("----------------------------------------------------------------------------");
                
        
        Shapes s4 = new Shapes();
        s4.borderColor = "Light Blue";
        s4.shapeName = "Triangle";
        s4.size = true;
        
        
        s4.others = new Extras<Shapes>();
        
        
        Shapes s4e1 =  new Shapes();
        s4e1.shapeName = "Circle";
        s4e1.borderColor = "Dark Blue";
        s4e1.filledColor = "Dark Blue";
        Shapes s4e2 = s4e1;
        
        s4.others.eyes.add(s4e1);
        s4.others.eyes.add(s4e2);
        
        Shapes s4m = new Shapes();
        s4m.borderColor = "Red";
        s4m.shapeName = "Box";               
        s4.others.mouthOuter = s4m;
        
        Shapes s4t = new Shapes();
        s4t.borderColor = "Black";
        s4t.shapeName = "Box";               
        s4t.equalSides = true;
        
        s4.others.teeth = new Shapes[3];
        Arrays.fill(s4.others.teeth, s4t);
        
        faces.list.add(s4);        
//        faces.drawFace(faces.list.get(3));
//        faces.inner(faces.list.get(3));
        
        
                
        System.out.println("----------------------------------------------------------------------------");
        
        
        
              
        
        
        
        Shapes s5 = new Shapes();
        s5.shapeName = "Box";
        s5.borderColor = "Maroon";
        s5.size = true;
                
        
        s5.others = new Extras<Shapes>();
        
        Shapes s5eyeOut = new Shapes();
        s5eyeOut.borderColor = "Red";
        s5eyeOut.shapeName = "Box";                
        s5.others.eyesOuter = s5eyeOut;
        s5.others.belongsToEachEye = false;
        
        
        Shapes s5e1= new Shapes();
        s5e1.borderColor = "Yellow";
        s5e1.shapeName = "Circle";
        s5e1.filledColor = "Orange";
        
        Shapes s5e2= new Shapes();
        s5e2.borderColor = "Yellow";
        s5e2.shapeName = "Circle";
        s5e2.filledColor = "Red";
                
        s5.others.eyes.add(s5e1);
        s5.others.eyes.add(s5e2);
        
        
        
        Shapes s5mouth = new Shapes();
        s5mouth.borderColor = "Black";
        s5mouth.shapeName = "Box";               
        s5.others.mouthOuter = s5mouth;
                
        Shapes s5Teeth1 = new Shapes();
        s5Teeth1.borderColor = "Orange";
        s5Teeth1.shapeName = "Triangle";
        s5Teeth1.pointAtTop = false;
        s5Teeth1.filledColor = "Red";
        
                
        
        Shapes s5Teeth2 = new Shapes();
        s5Teeth2.borderColor = "Orange";
        s5Teeth2.shapeName = "Triangle";
        s5Teeth2.pointAtTop = true;
        
        Shapes s5Teeth3 = s5Teeth2;

        
        Shapes s5Teeth4 = s5Teeth1;

        
        
        s5.others.teeth = new Shapes[4];
        s5.others.teeth[0]=s5Teeth1;
        s5.others.teeth[1]=s5Teeth2;
        s5.others.teeth[2]=s5Teeth3;
        s5.others.teeth[3]=s5Teeth4;
        
        
        faces.list.add(s5);        
//        faces.drawFace(faces.list.get(4));
//        faces.inner(faces.list.get(4));
        
        System.out.println("----------------------------------------------------------------------------");

        
        int i=1;
        for(Shapes face : faces.list){
            
            System.out.println("\t\t\t  For Face "+(i++));
            System.out.println("----------------------------------------------------------------------------");
            
            faces.drawFace(face);
            faces.inner(face);
            
            System.out.println("----------------------------------------------------------------------------");
        }
        
        

    }
    
    
}
