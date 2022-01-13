from flask import Flask
from os import path
from flask_login import LoginManager

from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView




def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'hjshjhdjah kjshkjdhjs'

    admin = Admin(app)

    from .views import views
    from .auth import auth
    

    app.register_blueprint(views, url_prefix='/')
    app.register_blueprint(auth, url_prefix='/')

    return app