/*Loja Snake2D-e modifikuar.
 *Kete loje e kame modifikuar qe Snake ti marrë dy topa me vlera te ndryshme dhe ta tregoje Rezultatin dhe Gjatesin e Gjarprit.
 *Nese merrë topin e verdhe i shtohet +1.
 *Nese merrë topin e kaltert i shtohet +2.
 *E kame bere edhe nese e humb lojen "Game Over"-mundet të luaje ende,vetem duke e liruar Snake-un.
 *E punoi Valdrin Ajvazi.*/


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.ImageIcon;



public class Gameplay extends JPanel implements KeyListener,ActionListener{


    private ImageIcon titleimage;
    private int[] snakeXlenght = new int[750];
    private int[] snakeYlenght = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;


    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;

    public int lengthofsnake = 3;

    private Timer timer;
    private int delay = 150;
    private int moves = 0;
    private ImageIcon snakeimage;
    private int scores;

// pozicionet e mundshme te topit te verdhe
    private int[] enemyXpos = {25,50,75,100,125,150,175,200,225,250,275,
            300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,
            675,700,725,750,775,800,825};
    private int[] enemyYpos ={75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625};
    
    //pozicionet e mundshme te topit te kaltert
    private int[] enemyXpos1 = {25,50,75,100,125,150,175,200,225,250,275,
            300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,
            675,700,725,750,775,800,825};
    private int[] enemyYpos1 ={75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625};


    private ImageIcon enemyimage;// per me e thirr topin e verdhe
    private Random random = new Random();// per te gjetur ne menyre randome pozicionin e ardhshem te topit te verdhe

    private int xpos = random.nextInt(33);// 33 pozita te enemyXpos
    private int ypos = random.nextInt(22);// 22 pozitat e enemyYpos
    
    private ImageIcon enemyimage1;// thirrja e topit te kalter
    private Random random1 = new Random();// per te gjetur ne menyre randome pozicionin e ardhshem te topit te kaltert

    private int xpos1 = random1.nextInt(33);// 33 pozita te enemyXpos1
    private int ypos1 = random1.nextInt(22);// 22 pozitat e enemyYpos1


    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();

    }

    public void paint(Graphics g)
    {
        if(moves == 0)
        {
            snakeXlenght[2]=50;
            snakeXlenght[1]=75;
            snakeXlenght[0]=100;

            snakeYlenght[2]=100;
            snakeYlenght[1]=100;
            snakeYlenght[0]=100;
        }
        g.setColor(Color.BLACK);
        g.drawRect(24,10,852,55);

        titleimage = new ImageIcon("snaketitle.jpg");
        titleimage.paintIcon(this,g,25,11);

        g.setColor(Color.BLACK);
        g.drawRect(24,74,851,577);

        g.setColor(Color.WHITE);
        g.fillRect(25 ,75,850,575);

        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.BOLD,14));
        g.drawString("Rezultati: "+ scores ,70,50);      


        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.BOLD,14));
        g.drawString("Gjatesia e Gjarprit: "+lengthofsnake,700,50);
                
       

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this,g,snakeXlenght[0],snakeYlenght[0]);

        for(int a = 0; a < lengthofsnake;a++)
        {
            if(a == 0 && right)
            {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this,g,snakeXlenght[a],snakeYlenght[a]);
            }
            if(a == 0 && left)
            {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this,g,snakeXlenght[a],snakeYlenght[a]);
            }
            if(a == 0 && down)
            {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this,g,snakeXlenght[a],snakeYlenght[a]);
            }
            if(a == 0 && up)
            {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this,g,snakeXlenght[a],snakeYlenght[a]);
            }
            if(a!=0)
            {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this,g,snakeXlenght[a],snakeYlenght[a]);
            }
        }
//verdhe-- nese gjarpri e han topin e verdhe shtohet +1
        enemyimage = new ImageIcon("enemy.png");
        if((enemyXpos[xpos] == snakeXlenght[0] && enemyYpos[ypos] == snakeYlenght[0]))
        {
        	
            scores++;
            lengthofsnake++;
            xpos = random.nextInt(33);
            ypos = random.nextInt(22);
        }
//kaltert-- nese e han topin e kalter shtohen +2
        enemyimage1 = new ImageIcon("ball.png");
        if((enemyXpos1[xpos1] == snakeXlenght[0] && enemyYpos1[ypos1] == snakeYlenght[0]))
        {
        	
            scores+=2;
            lengthofsnake+=2;
            xpos1 = random1.nextInt(33);
            ypos1 = random1.nextInt(22);
        }


        // vizatimi i topit te verdhe
        enemyimage.paintIcon(this,g,enemyXpos[xpos],enemyYpos[ypos]);
        

        // vizatimi i topit te kaltert        
        enemyimage1.paintIcon(this,g,enemyXpos1[xpos1],enemyYpos1[ypos1]);

        //gjarpri
        for(int b = 1;b < lengthofsnake;b++)
        {
            if(snakeXlenght[b]==snakeXlenght[0] && snakeYlenght[b]==snakeYlenght[0])
            {
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.black);
                g.setFont(new Font("serif",Font.BOLD,50));
                g.drawString("Game Over", 300,300);

                g.setFont(new Font("serif",Font.BOLD,25));
                g.drawString("Press Space Bar to RESTART", 300,340);
            }
        }
        g.dispose(); 
    }
     @Override
    public void actionPerformed(ActionEvent e)
    {
        timer.start();
        if(right)
        {
            for(int r =lengthofsnake - 1;r>=0;r--)
            {
                snakeYlenght[r + 1] = snakeYlenght[r];
            }
            for(int r = lengthofsnake ; r>=0;r--)
            {
                if(r==0)
                {
                    snakeXlenght[r] = snakeXlenght[r] + 25;
                }
                else
                {
                    snakeXlenght[r] = snakeXlenght[r-1];
                }
                if(snakeXlenght[r] > 850)
                {
                    snakeXlenght[r] = 25;
                }
            }
            repaint();
        }
        if(left)
        {
            for(int r =lengthofsnake - 1;r>=0;r--)
            {
                snakeYlenght[r + 1] = snakeYlenght[r];
            }
            for(int r = lengthofsnake ; r>=0;r--)
            {
                if(r==0)
                {
                    snakeXlenght[r] = snakeXlenght[r] - 25;
                }
                else
                {
                    snakeXlenght[r] = snakeXlenght[r-1];
                }
                if(snakeXlenght[r] < 25)
                {
                    snakeXlenght[r] = 850;
                }
            }
            repaint();
        }
        if(up)
        {
            for(int r =lengthofsnake - 1;r>=0;r--)
            {
                snakeXlenght[r + 1] = snakeXlenght[r];
            }
            for(int r = lengthofsnake ; r>=0;r--)
            {
                if(r==0)
                {
                    snakeYlenght[r] = snakeYlenght[r] - 25;
                }
                else
                {
                    snakeYlenght[r] = snakeYlenght[r-1];
                }
                if(snakeYlenght[r] < 75)
                {
                    snakeYlenght[r] = 625;
                }
            }
            repaint();
        }
        if(down)
        {
            for(int r =lengthofsnake - 1;r>=0;r--)
            {
                snakeXlenght[r + 1] = snakeXlenght[r];
            }
            for(int r = lengthofsnake ; r>=0;r--)
            {
                if(r==0)
                {
                    snakeYlenght[r] = snakeYlenght[r] + 25;
                }
                else
                {
                    snakeYlenght[r] = snakeYlenght[r-1];
                }
                if(snakeYlenght[r] > 625)
                {
                    snakeYlenght[r] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            moves = 0;
            scores = 0;
            lengthofsnake = 3;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            right = true;
            if (!left)
            {
                right = true;
            }
            else
                {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
            left = true;
            if (!right) {
                left = true;
            }
            else
                {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            }
            else
                {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            down = true;
            if (!up)
            {
                down = true;
            } else
                {
                down = false;
                up = true;
            }
            left = false;
            right = false;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}



