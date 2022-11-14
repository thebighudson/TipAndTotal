/**
 * Tip And Total Android application
 *
 * @author scaryguy
 * GitHub: thebighudson
 */

package the.big.hudson.tipandtotal

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTextView = this.findViewById<TextView>(R.id.infoTextView)
        infoTextView.visibility = View.INVISIBLE

        val calculateButton = this.findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {

            val bill = this.findViewById<TextView>(R.id.billInputTextField)
            if (bill.text.toString().equals("")) {
                infoTextView.text = "Please provide a bill amount";
                return@setOnClickListener
            }

            val billValue = bill.text.toString().toDouble()

            val tip = this.findViewById<TextView>(R.id.tipInputText)
            if (tip.text.toString().equals("")) {
                infoTextView.text =  "Please provide a tip amount";
                return@setOnClickListener
            }

            val tipValue = tip.text.toString().toDouble() / 100

            val tipped = billValue * tipValue
            val total = tipped + billValue

            infoTextView.visibility = VISIBLE
            //Generate tip and total text and display
            infoTextView.text = "Tip: ${doubleToDollar(tipped)} Total: ${doubleToDollar(total)}"
        }

        val clearButton = this.findViewById<Button>(R.id.clearButton)
        clearButton.setOnClickListener {
            val billField = this.findViewById<TextView>(R.id.billInputTextField)
            val tipField = this.findViewById<TextView>(R.id.tipInputText)

            billField.text = ""
            tipField.text = ""
            infoTextView.text = ""
        }
    }

    private fun doubleToDollar(number: Double): String {
        return buildString {
            append("$")
            append(String.format("%.2f", number))
        }
    }
}
