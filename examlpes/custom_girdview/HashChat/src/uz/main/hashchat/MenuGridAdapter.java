package uz.main.hashchat;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuGridAdapter extends BaseAdapter {

	private Context context;
	private Model model;

	public MenuGridAdapter(Context context, Model model) {
		this.model = model;
		this.context = context;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return model.Items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return model.Items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.gridr_row_layout, parent,	false);
		try {
			ImageView img = (ImageView) rowView.findViewById(R.id.img_grd);

			TextView txt_desc = (TextView) rowView
					.findViewById(R.id.txt_grid_desc);

			txt_desc.setText(model.GetbyId(position).getName());
			String fileName = model.GetbyId(position).getIconFile();
			InputStream ims = null;
	        try {
	            ims = context.getAssets().open(fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        // load image as Drawable
	        Drawable d = Drawable.createFromStream(ims, null);
	        // set image to ImageView
	        img.setImageDrawable(d);
			//if (fileName.equals("ic_chat.png"))
			//	img.setImageResource(R.drawable.ic_chat);
			//else if (fileName.equals("ic_msg.png"))
			//	img.setImageResource(R.drawable.ic_msg);
			//else if (fileName.equals("ic_search.png"))
			//	img.setImageResource(R.drawable.ic_search);
			//else if (fileName.equals("ic_voice.png"))
			//	img.setImageResource(R.drawable.ic_voice);
			//else if (fileName.equals("ic_tag.png"))
			//	img.setImageResource(R.drawable.ic_tag);
			//else if (fileName.equals("ic_favourite.png"))
			//	img.setImageResource(R.drawable.ic_favourite);
			//else if (fileName.equals("ic_settings.png"))
			//	img.setImageResource(R.drawable.ic_settings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowView;
	}

}
