public class Customer
{
    public List<Customer> SearchByCountry(string country)
    {
        var query = from c in db.Customers
                    where c.Country.Contains(country)
                    orderby c.CustomerID ascending
                    select c;

        return query.ToList();
    }

    public List<Customer> SearchByCompanyName(string companyName)
    {
        var query = from c in db.Customers
                    where c.CompanyName.Contains(companyName)
                    orderby c.CustomerID ascending
                    select c;

        return query.ToList();
    }

    public List<Customer> SearchByContact(string contact)
    {
        var query = from c in db.Customers
                    where c.ContactName.Contains(contact)
                    orderby c.CustomerID ascending
                    select c;

        return query.ToList();
    }
}