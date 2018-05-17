package nlpl.com.a3dm;

public class gcode_helper {

    //Only linear moves used G1 and homing G28
    public StringBuilder g_(int x)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('G');
        switch (x)
        {
            case 0: sb.append(0);
                break;

            case 1: sb.append(1);
                break;

            case 28: sb.append(28);
                break;

            case 29: sb.append(29);
                break;

            default:
        }
        return sb;
    }

    //for commands like M119 M84.
    public StringBuilder m_(int x)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('M');
        switch (x)
        {
            case 84: sb.append(84);
                break;

            case 119:sb.append(119);
                break;

            default:
        }
        return sb;
    }
}
