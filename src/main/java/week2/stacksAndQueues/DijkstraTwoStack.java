package week2.stacksAndQueues;

public class DijkstraTwoStack {
    GenericStack<String> ops = new GenericStackImpLinkList<String>();
    GenericStack<Integer> val = new GenericStackImpLinkList<Integer>();

    // if value: push onto value stack;
    // if operator: push onto the operator stack;  (+, *)
    // if left parenthesis: ignore
    // if right parenthesis: pop operator and two values. push the result onto the value stack.
    public int evaluate(String expression){
        String[] expressArray = expression.split(" "); // items separated by space.
        for (String item: expressArray){
            if(item.equals("*") || item.equals("+")){
                ops.push(item);
            }
            else if (item.equals("(")){
                // ignore
            }
            else if (item.equals(")")){
                String operator = ops.pop();
                int val1 = val.pop();
                int val2 = val.pop();
                if (operator.equals("+")){
                    val.push(val1+val2);
                }
                else{
                    val.push(val1*val2);
                }
            }
            else{
                val.push(Integer.parseInt(item));
            }
        }
        return val.pop();

    }
}
