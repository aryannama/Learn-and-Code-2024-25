public class CSVUtil
{
    public string ExportToCSV(List<Customer> customers)
    {
        StringBuilder stringBuilder = new StringBuilder();

        foreach (var customer in customers)
        {
            stringBuilder.AppendFormat("{0},{1}, {2}, {3}", customer.CustomerID, customer.CompanyName, customer.ContactName, customer.Country);
            stringBuilder.AppendLine();
        }

        return stringBuilder.ToString();
    }
}