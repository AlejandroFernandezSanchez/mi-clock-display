/**
 * Subido a un nuevo repositorio por los problemas que tuve con el último 
 * y por que tuve que empezar de 0 prácticamente.
 */
    public class ClockDisplay
{
    
        private NumberDisplay dia;
        
        private NumberDisplay mes;
    
        private NumberDisplay ano;
        
        private NumberDisplay minutos;
        
        private NumberDisplay horas;
        
        private String horaDisplay;
    

        public ClockDisplay()
        {
            horas = new NumberDisplay(24);
            minutos = new NumberDisplay(60);
            dia = new NumberDisplay(31);
            mes = new NumberDisplay(13);      
            ano = new NumberDisplay(100);
            updateDisplay();
        }
        

        public ClockDisplay(int horas2, int minutos2, int dia2, int mes2, int ano2)
        {
            horas = new NumberDisplay(24);
            minutos = new NumberDisplay(60);
            dia = new NumberDisplay(31);
            mes = new NumberDisplay(13);      
            ano = new NumberDisplay(100);
            horas.setValue(horas2);
            minutos.setValue(minutos2);
            dia.setValue(dia2);
            mes.setValue(mes2);
            ano.setValue(ano2);        
            updateDisplay();
        }
        

        public void setTime(int newHoras, int newMinutos)
        {
            horas.setValue(newHoras);
            minutos.setValue(newMinutos);
            updateDisplay();
        }
        

        public String getTime()
        {
            return horaDisplay;
        }
        

        public void timeTick()
       {
        minutos.increment();
        if(minutos.getValue() == 0)
        {
            horas.increment();
            if (horas.getValue() == 0)
            {
                dia.increment();
                if (dia.getValue() == 0)
                {
                    dia.increment();
                    mes.increment();
                    if (mes.getValue() == 0)
                    {
                        mes.increment();
                        ano.increment();
                    }                      
                }                        
            }           
        }
        updateDisplay();
       }
        

       public void updateDisplay()
        {
            int actualHour = horas.getValue();
            String displayedHour = "";
            String amPm = "";   
            boolean isMorning = true;
            
            if (actualHour == 0) 
            {
                displayedHour = "12";
                isMorning = true;
            }
            else if (actualHour < 10)
            {
                displayedHour = "0" + actualHour;
                isMorning = true;            
            }
            else if (actualHour < 12)
            {
                displayedHour = "" + actualHour;
                isMorning = true;            
            }
            else if (actualHour == 12)
            {
                displayedHour = "12";
                isMorning = false;
            }
            else if (actualHour < 22)
            {
                displayedHour = "0" + (actualHour - 12);
                isMorning = false;
            }
            else {
                displayedHour = "" + (actualHour- 12);
                isMorning = false;
            }
            
     
            if (isMorning) {
                amPm = "am";
            }
            else {
                amPm = "pm";
            }
            
            
            horaDisplay = displayedHour + ":" + minutos.getDisplayValue() + amPm + " " + dia.getDisplayValue() + "/" + 
            mes.getDisplayValue() + "/" + ano.getDisplayValue();
        }
}