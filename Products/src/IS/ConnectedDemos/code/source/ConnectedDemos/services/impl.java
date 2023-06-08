package ConnectedDemos.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.ibm.icu.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// --- <<IS-END-IMPORTS>> ---

public final class impl

{
	// ---( internal utility methods )---

	final static impl _instance = new impl();

	static impl _newInstance() { return new impl(); }

	static impl _cast(Object o) { return (impl)o; }

	// ---( server methods )---




	public static final void checkDatesByGivenFieldValues (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(checkDatesByGivenFieldValues)>> ---
		// @sigtype java 3.5
		// [i] record:0:required Document
		// [i] field:1:required fieldNames
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[]	fieldNames = IDataUtil.getStringArray( pipelineCursor, "fieldNames" );
		if (fieldNames.length == 0){
			throw new ServiceException("Please provide at least one field name to check!");
		}
		
		// Get the Document from the Pipeline
		IData document = IDataUtil.getIData( pipelineCursor, "Document" );
		if( document != null ) {
			// Iterate over all of the field names provided
			IDataCursor dc = document.getCursor();
			for( String name : fieldNames ) {
				// Check if the field name exists in the document provided
				if( dc.first(name) ) {
					Object value = dc.getValue();
					// Check the type of value provided for the document
					if( value instanceof String ) {
						try {
							// If a numeric value was provided, treat it as a delta (in secs) from the current time
							if( isNumeric((String)value) ) {
								Integer seconds = Integer.parseInt((String)value);
								dc.setValue( formatDate( addSecondsToCurrentDate(seconds).getTime() ) );
								System.out.println( formatDate( addSecondsToCurrentDate(seconds).getTime() ) );
							} else if( !((String)value).isEmpty() ) {
								// If a string was provided, ensure it's in the correct time/date format
								// Empty Strings are allowed, and ignored
								dc.setValue( formatDateString( (String)value ) );
								System.out.println( formatDateString( (String)value ) );
							}
						} catch( ParseException e ) {
							String message = "Error parsing: " + dc.getKey() + " is not in the correct format (yyyy-MM-dd'T'HH:mm:ssZ) or is not a valid amount of seconds: "+(String)value;
							throw new ServiceException(message);
						}
					} else {
						String message = "Error parsing: " + dc.getKey() + " is not a String type, and cannot be converted to a Date string value";
						throw new ServiceException( message );
					}
				}
			}
			dc.destroy();
		}
		pipelineCursor.destroy();
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static boolean isNumeric(String strNum){
		//check if String is numeric
		return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static String formatDateString(String dateString) throws ParseException {
		//Parse String for given Format
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		Date d = myFormat.parse(dateString); 
		return myFormat.format(d);
	}
	
	public static String formatDate(Date date) throws ParseException {
		//Parse String for given Format
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		return myFormat.format(date);
		
	}
	
	public static Calendar addSecondsToCurrentDate(Integer seconds){
		//add given/remove seconds to the current date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, seconds);
		
		return cal;
	}
	// --- <<IS-END-SHARED>> ---
}

