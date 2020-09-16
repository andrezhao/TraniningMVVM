package com.example.traniningmvvm.utils


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.FloatRange
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.annotation.StyleRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.traniningmvvm.R


abstract class MyDialog() : DialogFragment() {

    @LayoutRes
    var mLayoutResId = 0
    private var mDimAmount = 0.5f //背景昏暗度

    private var mShowBottomEnable //是否底部显示
            = false
    private var mMargin = 0 //左右边距

    private var mAnimStyle = 0 //进入退出动画

    private var mOutCancel = true //点击外部取消

    private var mContext: Context? = null
    private var mWidth = 0
    private var mHeight = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.margintran)
        mLayoutResId = setUpLayoutId()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(mLayoutResId, container, false)
        convertView(view, this)
        return view
    }

    override fun onStart() {
        super.onStart()
        initParams()
    }

    private fun initParams() {
        val window: Window? = dialog!!.window
        if (window != null) {
            val params: WindowManager.LayoutParams = window.getAttributes()
            params.dimAmount = mDimAmount

            //设置dialog显示位置
            if (mShowBottomEnable) {
                params.gravity = Gravity.BOTTOM
            }

            //设置dialog宽度
            if (mWidth === 0) {
                params.width = getScreenWidth(context) - 2 * dp2px(context, mMargin)
            } else {
                params.width = dp2px(context, mWidth)
            }

            //设置dialog高度
            if (mHeight === 0) {
                params.height = WindowManager.LayoutParams.WRAP_CONTENT
            } else {
                params.height = dp2px(context, mHeight)
            }

            //设置dialog动画
            if (mAnimStyle !== 0) {
                window.setWindowAnimations(mAnimStyle)
            }
            window.setAttributes(params)
        }
        isCancelable = mOutCancel
        dialog?.setCanceledOnTouchOutside(isCancelable);
    }

    /**
     * 设置背景昏暗度
     *
     * @param dimAmount
     * @return
     */
    fun setDimAmout(@FloatRange(from = 0.0, to = 1.0) dimAmount: Float): MyDialog? {
        mDimAmount = dimAmount
        return this
    }

    /**
     * 是否显示底部
     *
     * @param showBottom
     * @return
     */
    fun setShowBottom(showBottom: Boolean): MyDialog? {
        mShowBottomEnable = showBottom
        return this
    }

    /**
     * 设置宽高
     *
     * @param width
     * @param height
     * @return
     */
    fun setSize(width: Int, height: Int): MyDialog? {
        mWidth = width
        mHeight = height
        return this
    }

    /**
     * 设置左右margin
     *
     * @param margin
     * @return
     */
    fun setMargin(margin: Int): MyDialog? {
        mMargin = margin
        return this
    }

    /**
     * 设置进入退出动画
     *
     * @param animStyle
     * @return
     */
    fun setAnimStyle(@StyleRes animStyle: Int): MyDialog? {
        mAnimStyle = animStyle
        return this
    }

    /**
     * 设置是否点击外部取消
     *
     * @param outCancel
     * @return
     */
    fun setOutCancel(outCancel: Boolean): MyDialog? {
        mOutCancel = outCancel
        return this
    }

    fun show(manager: FragmentManager?): MyDialog? {
        if (manager != null) {
            super.show(manager, System.currentTimeMillis().toString())
        }
        return this
    }

    /**
     * 设置dialog布局
     *
     * @return
     */
    abstract fun setUpLayoutId(): Int

    /**
     * 操作dialog布局
     *
     * @param holder
     * @param dialog
     */
    abstract fun convertView(holder: View, dialog: MyDialog?)

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    fun getScreenWidth(context: Context?): Int {
        val displayMetrics = requireContext().resources.displayMetrics
        return displayMetrics.widthPixels
    }

    fun dp2px(context: Context?, dipValue: Int): Int {
        val scale = requireContext().resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }


}
