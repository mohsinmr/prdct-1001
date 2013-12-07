package uz.main.hashchat;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter  extends BaseAdapter{
	private final Context context;
    private Model model;
   
    public ListAdapter(Context context, Model objects) {

        super();

        this.context = context;
        this.model = objects;
       

    }

    @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return model.Items.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return model.Items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row_for_list, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgView);
        TextView textView = (TextView) rowView.findViewById(R.id.imgTxt);
        TextView textViewDesc = (TextView) rowView.findViewById(R.id.txtlistdesc);

        String imageFile = model.GetbyId(position).getIconFile();

        textView.setText(model.GetbyId(position).getName());
        textViewDesc.setText(model.GetbyId(position).getDesc());
        // get input stream
        InputStream ims = null;
        try {
            ims = context.getAssets().open(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // load image as Drawable
        Drawable d = Drawable.createFromStream(ims, null);
        // set image to ImageView
        imageView.setImageDrawable(d);
        return rowView;

    }

}
