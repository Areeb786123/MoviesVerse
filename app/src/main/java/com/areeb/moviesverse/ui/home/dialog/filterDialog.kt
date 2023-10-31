import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.areeb.moviesverse.R

@Composable
fun FilterDialog(showDialog: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = { showDialog(false) },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = colorResource(id = R.color.white),
            modifier = Modifier.padding(20.dp),
        ) {
            Column {
                Text(
                    text = "Filter",
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                )
                Spacer(modifier = Modifier.height(20.dp))
                FilterRadioGroup(listOf("Rating", "Date"))
            }
        }
    }
}

@Composable
fun FilterRadioGroup(option: List<String>) {
    Surface(modifier = Modifier.padding(20.dp).fillMaxWidth()) {
        var selected = 0
        Column {
            option.forEach {
                Row {
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = it,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.padding(top = 10.dp),
                    )
                }
            }
        }
    }
}