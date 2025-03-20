using System.Text;

public class DotGenerator
{
    public string GenerateDot(AstNode root)
    {
        var sb = new StringBuilder();
        sb.AppendLine("digraph AST {");
        sb.AppendLine("    node [shape=box, style=rounded, fontname=\"Courier New\"];");

        GenerateDotNode(sb, root);

        sb.AppendLine("}");
        return sb.ToString();
    }

    private void GenerateDotNode(StringBuilder sb, AstNode node)
    {
        sb.AppendLine($"    node{node.Id} [label=\"{Escape(node.Label)}\"];");

        foreach (var child in node.Children)
        {
            sb.AppendLine($"    node{node.Id} -> node{child.Id};");
            GenerateDotNode(sb, child);
        }
    }

    private string Escape(string text)
    {
        return text.Replace("\"", "\\\"");  // Escapar comillas dobles
    }
}
