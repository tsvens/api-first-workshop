package ConnectedDemosTCDB.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import com.softwareag.util.IDataArray;
import java.util.Arrays;
import java.util.List;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void listDataSetName (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(listDataSetName)>> ---
		// @sigtype java 3.5
		// [i] field:0:required connDataNodeName
		// [o] field:1:required datasetNames
		IDataCursor cursor = null;
		try {
			IData doInvoke = Service.doInvoke(NSName.create("wm.adapter.wmtcdb.dataset:list"), pipeline);
			cursor = doInvoke.getCursor();
			Object object = IDataUtil.get(cursor, "datasetData");
			IData[] dataSetNameObj = (IData[]) object;
			String[] dsnames = new String[dataSetNameObj.length];
			int i = 0;
			for (IData iData : dataSetNameObj) {
				
				dsnames[i++] = IDataUtil.getString(iData.getCursor(),"dataset");
			}
			
			//IDataUtil.put(cursor, "size", dataSetNameObj.length);
			
			IDataUtil.put(cursor, "datasetNames", dsnames);
			
		} catch (Exception e) {
			e.printStackTrace();
			if(null !=cursor)
			IDataUtil.put(cursor, "error", e.getMessage());
		}
		// --- <<IS-END>> ---

                
	}



	public static final void validateStringLists (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(validateStringLists)>> ---
		// @sigtype java 3.5
		// [i] field:1:required stringArray
		// [i] field:1:required valuesToCheckExist
		// [o] object:0:required isValid
		IDataCursor pipelineCursor = pipeline.getCursor();
		String[] origArray          = IDataUtil.getStringArray( pipelineCursor, "stringArray" );
		String[] valuesToCheckExist = IDataUtil.getStringArray( pipelineCursor, "valuesToCheckExist" );
		
		boolean containsAll = false; 
		
		if( origArray != null  ) {
		
			if (valuesToCheckExist == null || valuesToCheckExist.length == 0){
				throw new ServiceException("No values to check for in the string array!");
			}
			
			containsAll = true; 
			
			// Convert String Array to List
			List<String> list = Arrays.asList( origArray );        
			for (String keyword : valuesToCheckExist) {
				// Check if the name exists in the string array provided
			    if ( !list.contains( keyword ) ) {
			       containsAll = false;
			       break;
			    }
			}
		}
		
		IDataUtil.put(pipelineCursor, "isValid", containsAll);
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

