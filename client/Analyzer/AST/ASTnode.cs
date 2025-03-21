public class AstNode
{
    public string Label { get; set; }             
    public List<AstNode> Children { get; set; }   
    public int Id { get; private set; }           

    private static int counter = 0;
    
    public static void ResetCounter()
    {
        counter = 0;
    }

    public AstNode(string label)
    {
        this.Label = label;
        this.Children = new List<AstNode>();
        this.Id = counter++;
    }
    
    public void AddChild(AstNode child)
    {
        this.Children.Add(child);
    }
}