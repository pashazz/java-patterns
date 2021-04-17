# Chain of Responsibility pattern

Chain of responsibility means that we have a *request*,
that is going to be passed to handler. Each handler doesn't know about the next handler,
the *successor*. It does not care what happens next, it can decide that it could pass it to the next handler or not.

# Chain of Responsibility vs State

In contrast, **State** pattern means that the chain is built
as that each **Handler** knows what comes next and will pass the *Context* to known **State**.

# Example

Here, we implement authentication system. Each handler in the chain decides whether he could authenticate the
user using provided credentials or not, and if not, then pass to another handler in chain.

