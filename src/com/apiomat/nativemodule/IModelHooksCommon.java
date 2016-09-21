package com.apiomat.nativemodule;

/* common interface for hook classes */
public interface IModelHooksCommon<T>
{
	public void setCallingModel( T model );

	/**
	 * You can implement a custom authentication method in your own class.
	 * If access on an arbitrary model is checked, depending on the order in which an app configured its authentication
	 * classes, this class gets loaded and the authentication method gets called.
	 *
	 * Note: passwordOrToken only contains a token if the Model annotation
	 * {@link com.apiomat.nativemodule.Model#callAuthWithValidToken()} is set to {@value false} AND the token is valid.
	 * Invalid tokens get rejected by ApiOmat automatically.
	 *
	 * @param httpVerb GET / POST / DELETE / PUT
	 * @param modelName name of the model where the user wants access to
	 * @param modelForeignId foreign ID of the model where the user wants access to
	 * @param userNameOrEmail username or email of the user
	 * @param passwordOrToken password or token of the user
	 * @param request the request object
	 * @return TRUE on successful auth
	 */
	default public boolean auth( String httpVerb, String modelName, String modelForeignId, String userNameOrEmail,
		String passwordOrToken, Request request )
	{
		return false;
	}
}