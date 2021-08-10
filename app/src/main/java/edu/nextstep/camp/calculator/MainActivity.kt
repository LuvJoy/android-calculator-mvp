package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityMainBinding
import com.joseph.domain.Calculator
import com.joseph.domain.Expression
import com.joseph.domain.Operator

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener { presenter.addExpression(0) }
        binding.button1.setOnClickListener { presenter.addExpression(1) }
        binding.button2.setOnClickListener { presenter.addExpression(2) }
        binding.button3.setOnClickListener { presenter.addExpression(3) }
        binding.button4.setOnClickListener { presenter.addExpression(4) }
        binding.button5.setOnClickListener { presenter.addExpression(5) }
        binding.button6.setOnClickListener { presenter.addExpression(6) }
        binding.button7.setOnClickListener { presenter.addExpression(7) }
        binding.button8.setOnClickListener { presenter.addExpression(8) }
        binding.button9.setOnClickListener { presenter.addExpression(9) }
        binding.buttonPlus.setOnClickListener { presenter.addExpression(Operator.Plus) }
        binding.buttonMinus.setOnClickListener { presenter.addExpression(Operator.Minus) }
        binding.buttonMultiply.setOnClickListener { presenter.addExpression(Operator.Multiply) }
        binding.buttonDivide.setOnClickListener { presenter.addExpression(Operator.Divide) }
        binding.buttonDelete.setOnClickListener { presenter.removeAtLastExpression() }
        binding.buttonEquals.setOnClickListener { presenter.calculate() }
    }

    override fun displayExpression(expression: String) {
        binding.textView.text = expression
    }

    override fun showIncompleteExpressionToast() {
        Toast.makeText(this, R.string.incomplete_expression, Toast.LENGTH_SHORT).show()
    }
}
