import com.cycling74.max.*;

public class markov_arpeggiator extends MaxObject
{
  int last_note_in = 0;
  int last_note_out = 0;
  int first_note = 0;

  int[][] m = new int[128][129];

  public markov_arpeggiator(Atom[] args)
    {
      declareInlets(new int[]{DataTypes.ALL});
      declareOutlets(new int[]{DataTypes.ALL});
      int a;
      int b;
      for(a = 0; a < 128; a++)
        {
          for(b = 0; b < 129; b++)
            {
              m[a][b] = 0;
            }
        }
    }

  public void clear_matrix()
    {
      int a;
      int b;
      last_note_in = 0;
      last_note_out = 0;
      first_note = 0;
      for(a = 0; a < 128; a++)
        {
          for(b = 0; b < 129; b++)
            {
              m[a][b] = 0;
            }
        }
    }     
    
  public void bang()
    {
      double next_selection = 0;
      double temp = 0;
      int indx = 0;
      double count = m[last_note_out][128];

      if(count == 0)
        {       
          if(first_note > 0)
          {
            outlet(0, first_note);
            last_note_out = first_note;
          }
        }
      else
        {
          if(count == 1)
            {
              next_selection = 1;
            }
          else
            {
              next_selection = Math.floor(Math.random()*(count - 1)) + 1;
            }
          while (next_selection >= 1)
            {
              temp=next_selection - m[last_note_out][++indx];
              next_selection = temp;
              
            }
          outlet(0, indx);
          last_note_out = indx;
        }
      
    }
    
  public void inlet(int note)
    {
      m[last_note_in][note]++;
      m[last_note_in][128]++;
      last_note_in = note;
      if(first_note == 0)
        {
          first_note = note;
        }
        }
    
    public void inlet(float f)
        {
            post("no floats please\n");
        }
    
    
    public void list(Atom[] list)
        {
  
        }
    
}








