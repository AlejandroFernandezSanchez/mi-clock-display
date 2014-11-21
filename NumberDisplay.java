public class NumberDisplay
{
    private int display;  
    private int displayLimite;


    public NumberDisplay(int limite)
    {       
        display = 0;
        displayLimite = limite;
    }
    

    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < displayLimite)) {
            display = replacementValue;
        }
    }
    

    public String getDisplayValue()
    {
        String displayValue;
        if(display<10 & display>=0)
        {
            displayValue = "0" + display;
        }
        else
        {
            displayValue = "" + display;
        }
        return displayValue;
    }
    
  
    public int getValue()
    {
        int value;
        value = display;
        return value;
    }
    
    
    public void increment()
    {
       display = display + 1;
       
       if (display >= displayLimite) {
           display=0;
        }       
    }
}