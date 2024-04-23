import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    String[] strings = {
        "Hugg∑ing Face", "Analysis Group", "Strategy&", "ByteDance", "Asana", "Dropbox", "Anthropic", "Bloomberg", "Robinhood", "Intuit", "Quora", "Flow Traders", "Deutsche Bank", "Hulu", "Postmates", "IBM", "Balyasny Asset Management", "Affirm", "Nuro", "Waymo", "LinkedIn", "Jane Street", "Arrowstreet Capital", "Radix Trading", "Snowflake", "Five Rings", "Amazon", "The Brattle Group", "X", "Booz Allen Hamilton", "GrubHub", "Riot Games", "Evercore", "Akuna Capital", "Deloitte", "Morgan Stanley", "Blackrock", "Tesla", "DoorDash", "ServiceNow", "Glean", "Salesforce", "Citadel", "MRG", "Instacart", "Nutanix", "Box", "Jump Trading", "Workday", "OC&C", "Squarepoint Capital", "Renaissance Technologies", "Lazard", "Walmart", "OpenAI", "ZS", "Splunk", "VMware", "J.P. Morgan", "Lockheed Martin", "Neuralink", "GitHub", "Radix Trading", "Baupost Group", "Etsy", "Reddit", "Davidson Kempner Capital Management", "Guggenheim Securities", "Moelis & Company", "Elastic", "Zoom", "Slack", "Samsara", "Addepar", "Bolt", "Datadog", "Cisco", "Flow Traders", "WTW", "Tanium", "Airbnb", "Figma", "Plaid", "Two Sigma", "Hudson River Trading", "Cloudflare", "Apple", "Morgan Stanley", "Citadel", "Hudson River Trading", "MongoDB", "Wish", "Optiver", "Palantir", "Five Rings", "Optiver", "Autodesk", "Okta", "Third Point Partners", "AlixPartners", "Scale AI", "D.E. Shaw", "Credit Suisse", "Nextdoor", "Microsoft", "Duolingo", "DRW", "Slalom", "SIG", "Alvarez & Marsal", "Peloton", "D.E. Shaw", "Nvidia", "Shopify", "Jump Trading", "Spotify", "Roblox", "Flexport", "Cruise", "Goldman Sachs", "Brex", "Expedia", "Google", "HubSpot", "Oliver Wyman", "AQR Capital Management", "Brevan Howard", "Indeed", "Capital One", "Kearney", "Oracle", "IMC Trading", "Deepmind", "Ebay", "Adobe", "Retool", "Blackstone", "Twilio", "Jane Street", "Databricks", "Discord", "Twitch", "L.E.K.", "IMC Trading", "D.E. Shaw", "Publicis Sapient", "XTX Markets", "Centerview Partners", "Verily", "Uber", "Netflix", "Cohere", "Goldman Sachs", "PayPal", "Charles Schwab", "Yext", "Red Hat", "Intel", "Pinterest", "Egerton", "Airtable", "Bain & Company", "Capital One", "PwC", "Yelp", "Qualtrics", "BCG", "Samsung", "Notion", "Snap", "Docusign", "ExodusPoint", "Redfin", "KPMG", "Two Sigma", "Blue Origin", "Anduril", "Tableau", "McKinsey & Company", "Zillow", "Kayak", "NASA", "EY", "Ramp", "Accenture", "SpaceX", "Atlassian", "Bridgewater", "Blackrock", "Pine River Capital", "Millennium", "Rippling", "Farallon Capital", "Bank of America", "Lyft", "Canva", "Coinbase", "Renaissance Technologies", "Square", "JPMC", "Point72", "Akuna Capital", "Surveyor", "Barclays", "Elliott Management", "Square", "Meta"
    };

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());

    for (int i = 0; i < t; i++) {
      String line = reader.readLine();
      boolean contains = false;
      for (int j = 0; j < strings.length; j++) {
        if (line.equalsIgnoreCase(strings[j])) {
          System.out.println(j + 1);
          contains = true;
          break;
        }
      }
      if (!contains) {
        System.out.println(-1);
      }
    }
  }
}