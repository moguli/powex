<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="comm/include.inc.jsp"%>
<h2 class="contentTitle">添加虚拟币充值信息</h2>


<div class="pageContent">

	<form method="post" action="/buluo718admin/lockUserWallet.html"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,dialogAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>会员：</dt>
				<dd>
					<input type="hidden" name="uid" value="${fuser.fid}" />
					${fuser.floginName}
				</dd>
			</dl>
			<dl>
				<dt>虚拟币名称：</dt>
				<dd><input type="hidden" name="cid" value="${coin.fid}" />
					${coin.fname}
				</dd>
			</dl>
			<dl>
				<dt>钱包可用数量：</dt>
				<dd><input type="hidden" name="wid" value="${wallet.fid}" />${wallet.ftotal }</dd>
			</dl>
			<dl>
				<dt>钱包冻结数量：</dt>
				<dd>${wallet.ffrozen }
				</dd>
			</dl>
			<dl>
				<dt>钱包已锁仓数量：</dt>
				<dd>${wallet.flocked }
				</dd>
			</dl>
			<dl>
				<dt>操作：</dt>
				<dd>
					<input name="act" type="radio" value="lock" checked="checked"/>锁仓<br />
					<input name="act" type="radio" value="unlock" />解锁
				</dd>
			</dl>
			<dl>
				<dt>数量：</dt>
				<dd>
					<input type="text" name="fqty" maxlength="50" size="40"
						class="number required" />
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>

</div>


<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>
